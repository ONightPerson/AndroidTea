package com.android.liubz.androidtea.modules.scanner;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class UDPScanner {
    private static final String TAG = "UDPScanner";

    static final byte[] udpPacket = new byte[1];
    public static final int MASK = 0xff;


    public static boolean doScan(Context cxt) {
        DatagramSocket datagramSocket = null;
        try {

            DhcpInfo dhcpInfo = ((WifiManager) cxt.getSystemService(
                    Context.WIFI_SERVICE)).getDhcpInfo();
            int ip = dhcpInfo.ipAddress;
            Log.i(TAG, "doScan: ip to string: " + intToIP(ip));
            int a = ip & MASK;
            int b = (ip >> 8) & MASK;
            int c = (ip >> 16) & MASK;
            int d = (ip >> 24) & MASK;
            Log.i(TAG, "doScan: a: " + a + ", b: " + b + ", c: " + c + ", d: " + d);
            int netmask = dhcpInfo.netmask;
            int neta = netmask & MASK;
            int netb = (netmask >> 8) & MASK;
            int netc = (netmask >> 16) & MASK;
            int netd = (netmask >> 24) & MASK;
            Log.i(TAG, "doScan: neta: " + neta + ", netb: " + netb + ", netc: " + netc + ", netd: " + netd);
            List<String> subnetIPs = getIPsToScanInSubnet(ip, netmask);
            datagramSocket = new DatagramSocket();
            datagramSocket.setSoTimeout(100);
            datagramSocket.setBroadcast(true);
            datagramSocket.setReuseAddress(true);

            int port = 137;
            for (String subnetIP : subnetIPs) {
                datagramSocket.send(new DatagramPacket(udpPacket, udpPacket.length,
                        InetAddress.getByName(subnetIP), ++port));
            }
            datagramSocket.close();
            return true;
        } catch (Exception e) {
            Log.e(TAG, "doScan: ", e);
        }
        return false;
    }

    public static String intToIP(int longIp) {

        StringBuilder sb = new StringBuilder();
        // 直接右移24位
        sb.append(String.valueOf((longIp >>> 24)));
        sb.append(".");
        // 将高8位置0，然后右移16位
        sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
        sb.append(".");
        // 将高16位置0，然后右移8位
        sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
        sb.append(".");
        // 将高24位置0
        sb.append(String.valueOf((longIp & 0x000000FF)));
        return sb.toString();
    }

    public static List<String> getIPsToScanInSubnet(int ip, int netmask) {
        List<String> ipList = new ArrayList<>();
        int netid = ip & netmask;
        int netd = (netid >> 24) & MASK;
        Log.i(TAG, "getIPsToScanInSubnet: netd: " + netd);
        for (int nextip = addOnetoIP(ip); subnetContainsIP(nextip, ip, netmask); nextip = addOnetoIP(nextip)) {
            ipList.add(intToIp(netid));
            ip = nextip;
        }
        return ipList;
    }

    public static boolean subnetContainsIP(String ip, int gw, int subnet) {
        return subnetContainsIP(ipToInt(ip), gw, subnet);
    }

    public static int ipToInt(String ip) {
        String[] splitted = ip.split("\\.");
        if (splitted.length != 4) {
            return 0;
        }
        return (((0 + (Integer.parseInt(splitted[3]) << 24)) + (Integer.parseInt(splitted[2]) << 16))
                + (Integer.parseInt(splitted[1]) << 8)) + Integer.parseInt(splitted[0]);
    }

    public static String intToIp(int i) {
        return (i & MASK) + "." + ((i >> 8) & MASK)
                + "." + ((i >> 16) & MASK) + "." + ((i >> 24)
                & MASK);
    }

    public static boolean subnetContainsIP(int ip, int gw, int subnet) {
        return (ip & subnet) == (gw & subnet);
    }

    public static int addOnetoIP(int i) {
        int a = i & MASK;
        int b = (i >> 8) & MASK;
        int c = (i >> 16) & MASK;
        int d = ((i >> 24) & MASK) + 1;
        Log.i(TAG, "addOnetoIP: " + ",a: " + a + ", b: " + b + ", c: " + c + "d: " +d);
        if (d > MASK) {
            d = 1;
            c++;
            if (c > MASK) {
                c = 1;
                b++;
                if (b > MASK) {
                    b = 1 + 1;
                }
            }
        }
        return (((b << 8) + a) + (c << 16)) + (d << 24);
    }
}
