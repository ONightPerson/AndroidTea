package com.liubz.androidtea.cherish.methodinvoke.overxxx;

/**
 * @Desc:
 * javac -sourcepath /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java/com/liubz/androidtea/cherish/methodinvoke/overxxx/Cat.java
 * javap -c /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java/com/liubz/androidtea/cherish/methodinvoke/overxxx/Cat.class
 *  java -classpath  /Users/liubaozhu/priLib/AndroidTea/cherish/src/main/java com.liubz.androidtea.cherish.methodinvoke.overxxx.Cat
 * @Author: liubaozhu
 * @Date: 5/15/24 7:54 PM
 */
public class Cat extends Animal implements ISpeak {

    enum CatType {
        BRITISH,
        AMERICAN,
    }

    public void sleep() {
        System.out.println("cat sleep");
    }

    @Override
    public void sleep(long timeMillis) {
        super.sleep();
    }

    public static void sleep(boolean isDay) {
        System.out.println("sleep " + (isDay ? "during the day" : "at night"));
    }

    public void dailyActivities() {
        this.catchMouse();
        super.sleep();
        System.out.println(CatType.AMERICAN);
    }


    @Override
    public void speak() {
        System.out.println("Meow");
        catchMouse();
    }

    private void catchMouse() {
        System.out.println("catching mouse");
    }
}
