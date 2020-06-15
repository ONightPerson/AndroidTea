package com.android.liubz.androidtea.java.concurrency.producer_consumer.bean;

/**
 * Created by liubaozhu on 2019-09-26
 */
public class ExerciseBuffer {
    private int mAssignNumber = 0;
    private int mBufferNumber; // 待做测验题最大值
    private Column[] exercises; // 待做测验题buffer

    public ExerciseBuffer(int number) {
        mBufferNumber = number;
        exercises = new Column[number];
        for (int i = 0; i < mBufferNumber; i++) {
            exercises[i] = new Column();
        }
    }

    /**
     * 判断习题区是否满
     */
    public boolean isExercisesFull() {
        return !exercises[mBufferNumber - 1].hasDone();
    }

    /**
     * 判断习题区是否
     */
    public boolean isExercisesEmpty() {
        return exercises[0].hasDone();
    }

    /**
     * 老师出题
     */
    public void assignExercise() {
        for (int i = 0; i < mBufferNumber; i++) {
            if (exercises[i].hasDone()) {
                exercises[i].assign(new Exercise(++mAssignNumber));
                System.out.print(mAssignNumber);
                System.out.println();
                break;
            }
        }
    }

    /**
     * 学生做题
     */
    public void consumeExercise() {
        for (int i = mBufferNumber - 1; i >= 0; i--) {
            if (!exercises[i].hasDone()) {
                System.out.print(exercises[i].exercise.id);
                System.out.println();
                exercises[i].consume();
                break;
            }
        }
    }

    /**
     * 获取当前出题数
     */
    public int getAssignNumber() {
        return mAssignNumber;
    }
}
