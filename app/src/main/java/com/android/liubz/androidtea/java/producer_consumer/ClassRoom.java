package com.android.liubz.androidtea.java.producer_consumer;

import com.android.liubz.androidtea.java.producer_consumer.bean.ExerciseBuffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liubaozhu on 2019-09-26
 */
public class ClassRoom {


    ExerciseBuffer buffer = new ExerciseBuffer(10);
    ExecutorService exec = Executors.newCachedThreadPool();
    Teacher teacher = new Teacher(this);
    Student student1 = new Student(1, this);
    Student student2 = new Student(2, this);
    Student student3 = new Student(3, this);


    public void startExercise() {
        exec.execute(teacher);
        exec.execute(student1);
        exec.execute(student2);
        exec.execute(student3);
    }



    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.startExercise();

    }
}
