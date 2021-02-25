# 类加载过程剖析

## 一 类初始化
类主要在主动引用时，才会进行初始化；被动引用不会初始化。
### 1. 主动引用

1. 遇到 new（创建对象）、getstatic（读取类的静态变量）、putstatic（设置类的静态变量值）、invokestatic（调用静态方法） 这 4 个字节码指令时，如果类还没有进行过初始化，则需要先触发其初始化。
2. 反射一个类的时候，如果该类没有进行过初始化，则需要先触发初始化。
3. 当初始化一个类时，如果其父类还没有初始化过，需先触发其父类的初始化。
4. 当启动虚拟机时，用户需要指定一个入口类，虚拟机会先初始化这个类。
5. 当使用 JDK1.7 的动态语言支持时，如果 MethodHandle 实例最后的解析结果为 
REF_getStatic、REF_putStatic、REF_putStatic、REF_invokeStatic 的方法句柄，并且这个方法句柄对应的类还没有初始化过，需要先触发其初始化。


### 2. 被动引用
1. 引用父类的静态变量（参见 PassiveRefDemo类，可通过 -XX:+TraceClassLoading查看类加载详情）
2. 通过数组引用类 （参见 PassiveRefDemo类）
3. 引用静态常量 （参见ConstLoadClass类）
4. 引用静态常量2，static final Object 在编译器看来并不是真正的常量，只是语法层面的常量
不会触发初始化，但会加载该类 （参见ConstObjectLoadClass类）

## 二 类加载器

class文件 ----类加载器----> class对象，供JVM使用。class对象是class字节码文件在JVM层面的化身。

1. 数组的类加载器
	
	数组是一个引用类型，是由Java虚拟机动态生成的，该类继承了Object，实现了Serializable接口。数组的 Class 对象不是由 ClassLoader 创建的，而是 Java 运行时根据需要自动创建的。数组 class 的 ClassLoader 就是数组元素的 ClassLoader，如果数组元素类型是基本类型，那么这个数组就没有 ClassLoader。







