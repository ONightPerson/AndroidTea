package com.android.liubz.androidtea.network;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liubaozhu on 2019-11-19
 */
public class PacketReceiver {

    private static final String RESPONSE = "4448010831302e34322e302e31373700000000003235352e3235352e3235352e3000000031302e34322e302e310000000000000031302e34322e302e3100000000000000302e302e302e300000000000000000000c8c248e870400004950434d303030305a39474145594e0000000000000000000000000000000000697063616d30303000000000000000000000000000000000000000000000000046422d495043484e4e2d33365a3032003130342e313930363039303234353000000000000000000000000000000000000000000000000000000000000000000031342e31392e31322e31312e31373136523135313654303030310000000000000c010000000000000000000000000000000000000000000164663638386335323566383934303339303030303030303030303030303030300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
    private static final int LEN_MAC = 6;
    private static final int OFFSET_MAC = 0x50;
    private static final int OFFSET_FRIENDLY_NAME = 0x78;
    private static final int OFFSET_DEVICE_ID = 0x58;
    private static final int OFFSET_IP = 0x00;
    private static final int OFFSET_PORT = 0x56;
    private static final int OFFSET_DEV_TYPE = 0xF8;
    private static final int OFFSET_MODEL = 0x98;
    private static final int OFFSET_FIRMWARE_VERSION = 0xd8;

    public static void main(String[] args) {
        receive();
    }

    public static void receive() {
        byte[] response = hexStringToByteArray(RESPONSE);
        int contentLen = response.length - 4;
        byte[] content = new byte[contentLen];
        System.arraycopy(response, 4, content, 0, contentLen);
        String mac = getMac(content, OFFSET_MAC);
        System.out.println("mac: " + mac);
        try {
            String ip = getField(content, OFFSET_IP);
            System.out.println("ip: " + ip);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String friendlyName = getField(content, OFFSET_FRIENDLY_NAME);
            System.out.println("friendlyName: " + friendlyName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String model = getField(content, OFFSET_MODEL);
            System.out.println("model: " + model);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String deviceId = getField(content, OFFSET_DEVICE_ID);
            System.out.println("deviceId: " + deviceId);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String firmwareVer = getField(content, OFFSET_FIRMWARE_VERSION);
            System.out.println("firmwareVer: " + firmwareVer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int devType = content[OFFSET_DEV_TYPE];
        System.out.println("devType: " + devType);
        int port = getPort(content, OFFSET_PORT);
        System.out.println("port: " + port);
    }

    private static String getField(byte[] data, int offset) throws UnsupportedEncodingException {
        List<Byte> fieldList = new ArrayList<>();
        int len = data.length;
        for (int i = offset; i < len; i++) {
            if (data[i] == 0) {
                break;
            }
            fieldList.add(data[i]);
        }
        int fieldLen = fieldList.size();
        byte[] field = new byte[fieldLen];
        for (int i = 0; i < fieldLen; i++) {
            field[i] = fieldList.get(i);
        }
        return new String(field, 0, fieldLen, "UTF-8");
    }

    private static String getMac(byte[] data, int offset) {
        StringBuilder builder = new StringBuilder();
        for(int i = offset; i < offset + LEN_MAC; i += 1) { // 使用String的format方法进行转换
            builder.append(String.format("%02x:", new Integer(data[i] & 0xff)));
        }
        int len = builder.length();
        return builder.delete(len-1, len).toString();
    }

    private static int getPort(byte[] data, int offset) {
        return data[offset] << 8 + data[offset + 1];
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static void join1() {
        String result = "";
        long sta;
        for (int i = 0; i < 100000; i++) {
            result += "六六六";
        }
    }
}
