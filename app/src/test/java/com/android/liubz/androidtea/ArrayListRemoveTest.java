package com.android.liubz.androidtea;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ArrayListRemoveTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testRemove() {
        List<Integer> integers = new ArrayList() {{
            add(1);
            add(2);
            add(2);
            add(4);
            add(5);
        }};

        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i)%2==0){
                integers.remove(i);
            }
        }

        System.out.println(integers);
    }

    @Test
    public void testRemove2() {
        ArrayList<Integer> integers = new ArrayList() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        System.out.println(integers);
        integers.remove(1);
        System.out.println(integers);
    }

    @Test
    public void testRemove3() {
        List<String> list = Arrays.asList("a", "b");
        list.add("c");
        System.out.println(list);
    }

    @Test
    public void testRemove4(){
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");

        for (String string : strings) {
            strings.remove(string);
        }
    }

}