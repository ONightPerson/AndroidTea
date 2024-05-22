package com.liubz.androidtea.cherish.methodinvoke.overxxx;

/**
 * javac -sourcepath /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java/com/liubz/androidtea/cherish/methodinvoke/overxxx/MethodTest.java
 * javap -c /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java/com/liubz/androidtea/cherish/methodinvoke/overxxx/MethodTest.class
 * @Desc:
 * @Author: liubaozhu
 * @Date: 5/22/24 2:49 PM
 */
public class MethodTest {

    public static void main(String[] args) {
        // 重写和重载
        Animal animal = new Animal();
        Animal cat1 = new Cat();
        Cat cat2 = new Cat();

        animal.sleep(); // invokevirtual com/liubz/androidtea/cherish/methodinvoke/overxxx/Animal.sleep:()V
        cat1.sleep();   // invokevirtual com/liubz/androidtea/cherish/methodinvoke/overxxx/Animal.sleep:()V
        cat2.sleep();   // invokevirtual com/liubz/androidtea/cherish/methodinvoke/overxxx/Cat.sleep:()V

        animal.sleep(2000L); // invokevirtual com/liubz/androidtea/cherish/methodinvoke/overxxx/Animal.sleep:(J)V
        cat1.sleep(2000L);   // invokevirtual com/liubz/androidtea/cherish/methodinvoke/overxxx/Animal.sleep:(J)V
        cat2.sleep(2000L);   // invokevirtual com/liubz/androidtea/cherish/methodinvoke/overxxx/Cat.sleep:(J)V

        Animal.sleep(true);  // invokestatic com/liubz/androidtea/cherish/methodinvoke/overxxx/Animal.sleep:(Z)V
        cat1.sleep(true);    // invokestatic com/liubz/androidtea/cherish/methodinvoke/overxxx/Animal.sleep:(Z)V
        cat2.sleep(true);    // invokestatic com/liubz/androidtea/cherish/methodinvoke/overxxx/Cat.sleep:(Z)V
    }
}
