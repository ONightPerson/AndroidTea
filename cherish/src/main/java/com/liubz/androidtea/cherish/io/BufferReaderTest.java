package com.liubz.androidtea.cherish.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liubaozhu on 2021/2/3
 */
public class BufferReaderTest {

    public static void main(String[] args) {
        dynamicProxyMethod();
    }

    private static void markTest() throws IOException {
        BufferedReader r = new BufferedReader(new StringReader(
                "Happy Birthday to You!\n" +
                        "Happy Birthday, dear " + System.getProperty("user.name") + "!"));
        r.mark(1000); // save the data we are about to read
        System.out.println(r.readLine()); // read the first line
        r.reset(); // jump back to the marked position
        r.mark(1000); // start saving the data again
        System.out.println(r.readLine()); // read the first line again
        System.out.println(r.readLine()); // read the second line
        r.reset(); // jump back to the marked position
        System.out.println(r.readLine()); // read the first line one final time
    }

    interface Hello {
        void morning(String name);
    }

    private static void dynamicProxyMethod() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (proxy instanceof Hello) {
                    if (method.getName().equals("morning")) {
                        System.out.println("Good morning " + args[0]);
                    }
                }
                return null;
            }
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class<?>[] {Hello.class},
                handler
        );
        hello.morning("Jobs");
    }
}
