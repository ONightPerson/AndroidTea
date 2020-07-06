package com.liubz.androidtea.cherish.designpattern;

import java.io.IOException;

/**
 * Created by liubaozhu on 2019-10-22
 */
public class Cal {
    public static void main(String[] args) throws IOException {
        // 读取输入，方法1 BufferedReader
//        System.out.println("请输入数A:");
//        double numberA = Double.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine());
//        System.out.println("请输入数B: ");
//        double numberB = Double.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine());
//        System.out.println("请输入操作符:");
//        String op = String.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine());
//        System.out.println(Operation.getResult(numberA, numberB, op));

        // 方法2 Scanner
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入数A:");
//        double numberA = Double.valueOf(scanner.nextLine());
//        System.out.println("请输入数B: ");
//        double numberB = Double.valueOf(scanner.nextLine());
//        System.out.println("请输入操作符:");
//        String op = String.valueOf(scanner.nextLine());
//        System.out.println(Operation.getResult(numberA, numberB, op));

        // 方法3 Console
        System.out.println("请输入数A:");
        double numberA = Double.valueOf(System.console().readLine());
        System.out.println("请输入数B: ");
        double numberB = Double.valueOf(System.console().readLine());
        System.out.println("请输入操作符:");
        Operation operation = OperationFactory.createOperation(System.console().readLine());
        operation.setNumber(numberA, numberB);
        try {
            System.out.println(operation.op());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
