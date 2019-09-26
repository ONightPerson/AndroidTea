package com.android.liubz.androidtea;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.xbill.DNS.DClass;
import org.xbill.DNS.ExtendedFlags;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Rcode;
import org.xbill.DNS.Record;
import org.xbill.DNS.ReverseMap;
import org.xbill.DNS.Section;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.Type;
import org.xbill.DNS.ResolverListener;

/** @author Brian Wellington &lt;bwelling@xbill.org&gt; */
public class Dig {

    static Name name = null;
    static int type = Type.A, dclass = DClass.IN;

    static void usage() {
        System.out.println("Usage: dig [@server] name [<type>] [<class>] " + "[options]");
        System.exit(0);
    }

    static void doQuery(Message response, long ms) {
        System.out.println("; java dig 0.0");
        System.out.println(response);
        System.out.println(";; Query time: " + ms + " ms");
    }

    static void doAXFR(Message response) {
        System.out.println("; java dig 0.0 <> " + name + " axfr");
        if (response.isSigned()) {
            System.out.print(";; TSIG ");
            if (response.isVerified()) {
                System.out.println("ok");
            } else {
                System.out.println("failed");
            }
        }

        if (response.getRcode() != Rcode.NOERROR) {
            System.out.println(response);
            return;
        }

        Record[] records = response.getSectionArray(Section.ANSWER);
        for (Record record : records) {
            System.out.println(record);
        }

        System.out.print(";; done (");
        System.out.print(response.getHeader().getCount(Section.ANSWER));
        System.out.print(" records, ");
        System.out.print(response.getHeader().getCount(Section.ADDITIONAL));
        System.out.println(" additional)");
    }

    public static void main(String[] argv) throws Exception {
        String server = null;
        int arg;
        final Message query, response;
        Record rec;
        SimpleResolver res = null;
        boolean printQuery = false;
        long startTime, endTime;

        if (argv.length < 1) {
            usage();
        }

        try {
            arg = 0;
            if (argv[arg].startsWith("@")) {
                server = argv[arg++].substring(1);
            }

            if (server != null) {
                System.out.println("server: " + server);
                res = new SimpleResolver(server);
            } else {
                res = new SimpleResolver();
            }

            String nameString = argv[arg++];
            if (nameString.equals("-x")) {
                name = ReverseMap.fromAddress(argv[arg++]);
                System.out.println("name: " + name);
                type = Type.PTR;
                dclass = DClass.IN;
            } else {
                name = Name.fromString(nameString, Name.root);
                type = Type.value(argv[arg]);
                if (type < 0) {
                    type = Type.A;
                } else {
                    arg++;
                }

                dclass = DClass.value(argv[arg]);
                if (dclass < 0) {
                    dclass = DClass.IN;
                } else {
                    arg++;
                }
            }

            while (argv[arg].startsWith("-") && argv[arg].length() > 1) {
                switch (argv[arg].charAt(1)) {
                    case 'p':
                        String portStr;
                        int port;
                        if (argv[arg].length() > 2) {
                            portStr = argv[arg].substring(2);
                        } else {
                            portStr = argv[++arg];
                        }
                        port = Integer.parseInt(portStr);
                        System.out.println("port: " + port);
                        if (port < 0 || port > 65535) {
                            System.out.println("Invalid port");
                            return;
                        }
                        res.setPort(port);
                        break;

                    case 'b':
                        String addrStr;
                        if (argv[arg].length() > 2) {
                            addrStr = argv[arg].substring(2);
                        } else {
                            addrStr = argv[++arg];
                        }
                        InetAddress addr;
                        try {
                            addr = InetAddress.getByName(addrStr);
                        } catch (Exception e) {
                            System.out.println("Invalid address");
                            return;
                        }
                        res.setLocalAddress(addr);
                        break;

                    case 'k':
                        String key;
                        if (argv[arg].length() > 2) {
                            key = argv[arg].substring(2);
                        } else {
                            key = argv[++arg];
                        }
                        res.setTSIGKey(TSIG.fromString(key));
                        break;

                    case 't':
                        res.setTCP(true);
                        break;

                    case 'i':
                        res.setIgnoreTruncation(true);
                        break;

                    case 'e':
                        String ednsStr;
                        int edns;
                        if (argv[arg].length() > 2) {
                            ednsStr = argv[arg].substring(2);
                        } else {
                            ednsStr = argv[++arg];
                        }
                        edns = Integer.parseInt(ednsStr);
                        if (edns < 0 || edns > 1) {
                            System.out.println("Unsupported " + "EDNS level: " + edns);
                            return;
                        }
                        res.setEDNS(edns);
                        break;

                    case 'd':
                        res.setEDNS(0, 0, ExtendedFlags.DO, null);
                        break;

                    case 'q':
                        printQuery = true;
                        break;

                    default:
                        System.out.print("Invalid option: ");
                        System.out.println(argv[arg]);
                }
                arg++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            if (name == null) {
                usage();
            }
        }
        if (res == null) {
            res = new SimpleResolver();
        }

        rec = Record.newRecord(name, type, dclass);
        query = Message.newQuery(rec);
//        System.out.println("query: " + query);
        if (printQuery) {
            System.out.println(query);
        }
        startTime = System.currentTimeMillis();
        MyRunnalbe task = new MyRunnalbe(res, query);
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(task);


        TimeUnit.SECONDS.sleep(20);
        exec.shutdownNow();
        endTime = System.currentTimeMillis();

//        if (type == Type.AXFR) {
//            doAXFR(response);
//        } else {
//            doQuery(response, endTime - startTime);
//        }
    }

    static class MyRunnalbe implements Runnable {
        private SimpleResolver mResolver;
        private Message mQuery;

        public MyRunnalbe(SimpleResolver resolver, Message query) {
            mResolver = resolver;
            mQuery = query;
        }

        @Override
        public void run() {
            mResolver.sendAsync(mQuery, new ResolverListener() {
                @Override
                public void receiveMessage(Object id, Message m) {
                    System.out.println("msg: " + m);
                }

                @Override
                public void handleException(Object id, Exception e) {
                    System.out.println("error: " + e);
                }
            });
        }
    }
}
