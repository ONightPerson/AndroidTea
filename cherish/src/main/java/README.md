在 Java 中，使用 java 命令来执行编译后的 .class 文件。以下是基于上面例子的详细步骤和说明：

1. 文件结构
   假设文件结构如下：

project/
├── src/
│   └── com/
│       └── example/
│           ├── Main.java
│           └── utils/
│               └── StringUtils.java
├── lib/
│   └── mylib.jar
└── classes/
    └── com/
        └── example/
            ├── Main.class
            └── utils/
                └── StringUtils.class
Main.java 是主类，包含 main 方法。
StringUtils.java 是一个工具类，被 Main.java 使用。
classes 目录是编译后的类文件输出目录。
lib/mylib.jar 是一个外部库，Main.java 依赖于它。
2. 编译代码
   首先，确保已经编译了代码，生成 .class 文件。可以使用以下命令：

bash
javac -sourcepath src -classpath lib/mylib.jar -d classes src/com/example/Main.java
3. 执行 .class 文件
   使用 java 命令执行编译后的 .class 文件。需要注意以下几点：

类路径（-classpath 或 -cp）：指定 .class 文件和依赖库的位置。
主类名：指定包含 main 方法的类的全限定名（包括包名）。
执行命令
bash
java -classpath classes:lib/mylib.jar com.example.Main
参数说明
-classpath classes:lib/mylib.jar：
classes：指定编译后的 .class 文件所在的目录。
lib/mylib.jar：指定依赖的外部库文件。
在 Windows 系统中，路径分隔符使用 ;，例如 classes;lib/mylib.jar。
在 Linux/macOS 系统中，路径分隔符使用 :，例如 classes:lib/mylib.jar。
com.example.Main：主类的全限定名（包名 + 类名）。
4. 示例代码
   假设 Main.java 的内容如下：

java
package com.example;

import com.example.utils.StringUtils;

public class Main {
public static void main(String[] args) {
String message = "Hello, World!";
String reversed = StringUtils.reverse(message);
System.out.println("Original: " + message);
System.out.println("Reversed: " + reversed);
}
}
StringUtils.java 的内容如下：

java
package com.example.utils;

public class StringUtils {
public static String reverse(String str) {
return new StringBuilder(str).reverse().toString();
}
}
执行后，输出结果：

Original: Hello, World!
Reversed: !dlroW ,olleH
5. 总结
   使用 java 命令执行 .class 文件时，需要指定类路径（-classpath 或 -cp）和主类的全限定名。
   类路径需要包含编译后的 .class 文件目录和依赖的库文件。
   主类的全限定名需要包括包名和类名，例如 com.example.Main。