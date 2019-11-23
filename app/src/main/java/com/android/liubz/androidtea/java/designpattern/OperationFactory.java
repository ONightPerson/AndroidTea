package com.android.liubz.androidtea.java.designpattern;

/**
 * Created by liubaozhu on 2019-10-24
 */
public class OperationFactory {

    public static Operation createOperation(String op) {
        Operation operation = null;
        switch (op) {
            case "+":
                operation = new Add();
                break;
            case "-":
                operation = new Subtract();
                break;
            case "*":
                operation = new Multiply();
                break;
            case "/":
                operation = new Div();
                break;
            case "%":
                operation = new Mod();
            default:
                break;
        }
        return operation;
    }
}
