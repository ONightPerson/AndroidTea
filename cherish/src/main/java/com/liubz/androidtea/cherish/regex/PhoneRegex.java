package com.liubz.androidtea.cherish.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 7/10/24 5:41 PM
 */
public class PhoneRegex {

    // 定义用于匹配和替换的正则表达式
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\d{3})(\\d{1,3})(\\d*)$");

    public static void main(String[] args) {
        // 示例手机号
        String[] phoneNumbers = {
          "1234567890",  // 10位
          "12345",       // 5位
          "123456",      // 6位
          "1234567",      // 7位
          "123456789012345" // 15位
        };

        // 打印掩码后的手机号
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
            System.out.println(maskPhoneNumber(phoneNumber));
        }
    }

    private static String maskPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{5,15}")) {
            throw new IllegalArgumentException("手机号必须是5到15位的数字");
        }
        Matcher matcher = PHONE_PATTERN.matcher(phoneNumber);
        if (matcher.matches()) {
            String part1 = matcher.group(1); // 前3位
            String part2 = matcher.group(2); // 第4到6位
            String part3 = matcher.group(3); // 剩下的部分
            System.out.println("part3： " + part3);
            String mask = part2.replaceAll(".", "*");
            return part1 + mask + part3;
        }
        return phoneNumber;
    }
}
