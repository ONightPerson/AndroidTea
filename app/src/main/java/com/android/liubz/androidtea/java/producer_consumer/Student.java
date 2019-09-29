package com.android.liubz.androidtea.java.producer_consumer;

/**
 * Created by liubaozhu on 2019-09-26
 */
public class Student implements Runnable {
    private int mId;
    private ClassRoom mClassRoom;

    public Student(int id, ClassRoom classRoom) {
        mId = id;
        mClassRoom = classRoom;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (mClassRoom.buffer) {
                    while (mClassRoom.buffer.isExercisesEmpty()) {
                        mClassRoom.buffer.wait();
                    }

                    boolean isTestAreaFull = mClassRoom.buffer.isExercisesFull();
                    System.out.print("Student " + mId + " take exercise ");
                    mClassRoom.buffer.consumeExercise();
                    if (isTestAreaFull) {
                        mClassRoom.buffer.notifyAll();
                    }
                }

            }
        } catch (InterruptedException e) {
            System.out.println("Interrupt student's consuming tests: " + e);
        }

    }
}
