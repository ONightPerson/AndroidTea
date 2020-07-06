//: net/mindview/util/TextFile.java
// Static functions for reading and writing text files as
// a single string, and treating a file as an ArrayList.
package com.liubz.androidtea.cherish.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextFile extends ArrayList<String> {

  public TextFile(String fileName, String splitter) {
    super(Arrays.asList(read(fileName).split(splitter)));
    if(get(0).equals("")) {
      remove(0);
    }
  }
  public TextFile(String fileName) {
    this(fileName, "\n");
  }

  // Read a file as a single string:
  public static String read(String fileName) {
    StringBuilder sb = new StringBuilder();
    try {
      BufferedReader in= new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
      try {
        String s;
        while((s = in.readLine()) != null) {
          sb.append(s);
          sb.append("\n");
        }
      } finally {
        in.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }
  // Write a single file in one method call:
  public static void write(String fileName, String text) {
    try {
      PrintWriter out = new PrintWriter(
        new File(fileName).getAbsoluteFile());
      try {
        out.print(text);
      } finally {
        out.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void write(String fileName) {
    try {
      PrintWriter out = new PrintWriter(
        new File(fileName).getAbsoluteFile());
      try {
        for(String item : this)
          out.println(item);
      } finally {
        out.close();
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
//    String file = read("TextFile.java");
//    write("test.txt", file);
//    TextFile text = new TextFile("test.txt");
//    text.write("test2.txt");
//    // Break into unique sorted list of words:
//    TreeSet<String> words = new TreeSet<String>(
//      new TextFile("TextFile.java", "\\W+"));
//    // Display the capitalized words:
//    System.out.println(words.headSet("a"));

    TextFile text = new TextFile("/Users/liubaozhu/local_repo/AndroidTea/app/src/main/java/" +
            "com/android/liubz/androidtea/java/io/Directory.java");
    Map<Character, Integer> map = new HashMap<>();
    for (String item : text) {
      char[] line = item.toCharArray();
      for (char slice: line) {
        if (map.containsKey(slice)) {
          map.put(slice, map.get(slice) + 1);
        } else {
          map.put(slice, 1);
        }
      }
    }

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
