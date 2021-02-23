# 类初始化
类主要在主动引用时，才会进行初始化；被动引用不会初始化。
## 主动引用

1. 遇到 new（创建对象）、getstatic（读取类的静态变量）、putstatic（设置类的静态变量值）、invokestatic（调用静态方法） 这 4 个字节码指令时，如果类还没有进行过初始化，则需要先触发其初始化。
2. 反射一个类的时候，如果该类没有进行过初始化，则需要先触发初始化。
3. 当初始化一个类时，如果其父类还没有初始化过，需先触发其父类的初始化。
4. 当启动虚拟机时，用户需要指定一个入口类，虚拟机会先初始化这个类。
5. 当使用 JDK1.7 的动态语言支持时，如果 MethodHandle 实例最后的解析结果为 
REF_getStatic、REF_putStatic、REF_putStatic、REF_invokeStatic 的方法句柄，并且这个方法句柄对应的类还没有初始化过，需要先触发其初始化。


## 被动引用
1. 引用父类的静态变量（参见 PassiveRefDemo类，可通过 -XX:+TraceClassLoading查看类加载详情）
2. 通过数组引用类 （参见 PassiveRefDemo类）
3. 引用静态常量 （参见ConstLoadClass类）
4. 引用静态常量2，static final Object 在编译器看来并不是真正的常量，只是语法层面的常量
不会触发初始化，但会加载该类 （参见ConstObjectLoadClass类）






