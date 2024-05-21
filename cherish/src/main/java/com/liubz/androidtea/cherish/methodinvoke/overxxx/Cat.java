package com.liubz.androidtea.cherish.methodinvoke.overxxx;

/**
 * @Desc:
 * javac -sourcepath /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java/com/liubz/androidtea/cherish/methodinvoke/overxxx/Cat.java
 *  javap -c /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java/com/liubz/androidtea/cherish/methodinvoke/overxxx/Cat.class
 *  java -classpath  /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java com.liubz.androidtea.cherish.methodinvoke.overxxx.Cat
 * @Author: liubaozhu
 * @Date: 5/15/24 7:54 PM
 */
public class Cat extends Animal {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.dailyActivities();
    }

    @Override
    public void eat() {
        System.out.println(this.getClass().getSimpleName() + " eat");
    }

    public void dailyActivities() {
        eat();
        super.sleep();
    }
}
