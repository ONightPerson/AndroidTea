package com.android.liubz.androidtea;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.impl.JmDNSImpl;
import javax.jmdns.impl.HostInfo;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

//import org.xbill.DNS.ExtendedResolver;
//import org.xbill.DNS.Lookup;
//import org.xbill.DNS.Name;
//import org.xbill.DNS.PTRRecord;
//import org.xbill.DNS.Record;
//import org.xbill.DNS.Resolver;
//import org.xbill.DNS.ReverseMap;
//import org.xbill.DNS.Type;

/**
 * Created by liubaozhu on 2019-09-10
 */
public class DomainTest {
    private static final String HOSTNAME = "BonHt";

    public static void main(String[] args) throws Exception {
//        final InetAddress ip2 = InetAddress.getByName("192.168.31.52");
//        final byte[] bytes = ip2.getAddress();
//        final String host = getHostByIPAddress(bytes);
//        System.out.println("\nJAVADISCOVER HOST : " + host);

//        testIP("192.168.31.52");
        printDomain();
    }

//    public static String getHostByIPAddress(byte[] addr) throws UnknownHostException {
//
//        Name name = ReverseMap.fromAddress(InetAddress.getByAddress(addr));
//
//        // OPEN DNS SERVERS
//        final String[] openDNS = new String[] {"208.67.222.222", "208.67.220.220"};
//        final Resolver resolver = new ExtendedResolver(openDNS);
//        final Lookup lookUp = new Lookup(name, Type.PTR);
//        lookUp.setResolver(resolver);
//        Record[] records = lookUp.run();
//        if (records == null) {
//            throw new UnknownHostException();
//        }
//        return ((PTRRecord) records[0]).getTarget().toString();
//    }

    private static void testIP(String ip) throws UnknownHostException {
        byte[] address=toIpByte(ip);
        System.out.println(Arrays.toString(address));
        InetAddress addr = InetAddress.getByAddress(address);
        System.out.println(addr.getHostName());
    }

    private static byte[] toIpByte(String ip) {
        String[] ips=ip.split("\\.");
        byte[] address=new byte[ips.length];
        for (int i=0;i<ips.length;i++)
        {
            address[i]=(byte) Integer.parseInt(ips[i]);
        }
        return address;
    }

    private static void printDomain() {
        try {
//            JmDNSImpl jmdns = (JmDNSImpl) JmDNS.create(getIpAddress("192.168.31.233"), HOSTNAME);
            JmDNSImpl jmdns = new JmDNSImpl(null, null);
            final HostInfo hostInfo = HostInfo.newHostInfo(InetAddress.getByName("192.168.31.52"), jmdns, null);
            System.out.println("MDNS hostname (Bonjour): " + hostInfo.getName());
            System.out.println("DNS hostname: " + hostInfo.getInetAddress().getHostName());
            System.out.println("IP address: " + hostInfo.getInetAddress().getHostAddress());
            jmdns.close();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }

    }

    public static InetAddress getIpAddress(String ip) throws UnknownHostException {
//        WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
//        int ip = wifiInfo.getIpAddress();
//
//        if (ip == 0) {
//            return null;
//        }
//        else {
//            byte[] ipAddress = convertIpAddress(ip);
//            return InetAddress.getByAddress(ipAddress);
//        }
        return InetAddress.getByName(ip);
    }

    public static byte[] convertIpAddress(int ip) {
        return new byte[] {
                (byte) (ip & 0xFF),
                (byte) ((ip >> 8) & 0xFF),
                (byte) ((ip >> 16) & 0xFF),
                (byte) ((ip >> 24) & 0xFF)};
    }
}
