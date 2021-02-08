package com.liubz.androidtea.cherish.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by liubaozhu on 2021/2/3
 */
public class SystemTest {

    public static void main(String[] args) {
        try {
            systemIn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printAllProperties() {
        Properties properties = System.getProperties();
        Set<Object> keySet = properties.keySet();
        for (Object key : keySet) {
            String value = (String) properties.get(key);
            System.out.println(key + " -----> " + value);
        }
    }

    public static void printSingleProperty(String key) {
        Properties properties = System.getProperties();
        String value = properties.getProperty(key);
        System.out.println(value);
    }

    public static void customSetProperty() {
        Properties properties = System.getProperties();
        properties.setProperty("myFavourite", "pingpang");
        System.out.println(properties.getProperty("myFavourite"));
    }

    public static void getAllEnv() {
        Map<String, String> envs = System.getenv();
        Set<String> envKeys = envs.keySet();
        for (String name : envKeys) {
            System.out.println(name + " ----> " + envs.get(name));

        }
    }

    public static void systemIn() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals("over")) {
                break;
            }
            System.out.println(line.toUpperCase());
        }
    }
}
