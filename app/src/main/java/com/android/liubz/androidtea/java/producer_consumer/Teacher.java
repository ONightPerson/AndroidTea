package com.android.liubz.androidtea.java.producer_consumer;


/**
 * Created by liubaozhu on 2019-09-26
 */
public class Teacher implements Runnable {
    private static final String TAG = "Teacher";

    private static final int TEST_MAX = 500;

    private ClassRoom mClassRoom;

    public Teacher(ClassRoom classRoom) {
        mClassRoom = classRoom;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (mClassRoom.buffer) {
                    while (mClassRoom.buffer.isExercisesFull()) {
                        mClassRoom.buffer.wait();
                    }
                    boolean isTestAreaEmpty = mClassRoom.buffer.isExercisesEmpty();
                    System.out.print("Teacher assign exercise ");
                    mClassRoom.buffer.assignExercise(); // 出题
                    if (mClassRoom.buffer.getAssignNumber() == TEST_MAX) {
                        System.out.println("The exercises of task today is over");
                        mClassRoom.exec.shutdownNow();
                    }
                    System.out.println("Exercise !!!");
                    if (isTestAreaEmpty) {
                        System.out.println("to notify students");
                        mClassRoom.buffer.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupt teacher's assigning tests : " + e);
        }

    }
}
