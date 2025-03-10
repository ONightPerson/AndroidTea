import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 4/10/24 4:25 PM
 */
public class CommonTest implements Speak {
    private static final String TAG = "CommonTest";

    @Override
    public void speak(String msg) {
        System.out.println("speak: " + msg);

    }

    public void loadData(int age, String name, boolean male, long birthday) {
        System.out.println(age + name + male + birthday);
    }

    public void infinityNaN() {
        int i = 10;
        double j = i / 0.0;
        System.out.println(j); // Infinity

        double d1 = 0.0d;
        double d2 = d1 / 0.0d;
        System.out.println(d2); // NaN

        double d3 = 1.0d;
        double d4 = d3 / 0.0d;
        System.out.println(d4); // Infinity
    }

    public void pushLoadLdc() {
        int iconst = -1;
        int bipush = 127;
        int siPush = 32767;
        int ldc = 32768;
        String aconst = null;
        String idcString = "动物保护发";
    }

    public void calculate(int age) {
        int add = age + 1;
        int sub = age - 1;
        int mul = age * 2;
        int div = age / 2;
        int mod = age % 2;
        age++;
        age--;
    }

    public void upDown() {
        int i = 10;
        double d = i;
        float f = 10f;
        long l = (long) f;
    }

    public void newObject() {
        String name = new String("hello");
        String[] names = new String[]{"1", "2", "3"};
        int[] ages = new int[]{1, 2, 3};
    }

    private void run() {
        List ls = new ArrayList();
        ls.add("难顶");

        ArrayList als = new ArrayList();
        als.add("学不动了");
    }

    public void invokeDynamic() {
        Function<Integer, Integer> square = x -> x * x;
        int result = square.apply(5);
        System.out.println(result);
    }

    public final void testFinal() {
        System.out.println("testFinal");
    }


    public static final String[] s = {"1", "2", "3"};

    public static void main(String[] args) {
        new CommonTest().testFinal();
    }

    int age;

    public int incAndGet() {
        return ++age;
    }

    public void testCmp(int a, int b) {
        if (a > b) {
            System.out.println("a > b");
        } else {
            System.out.println("a <= b");
        }

    }

    public void switchTest(int select) {
        int num;
        switch (select) {
            case 1:
                num = 10;
                break;
            case 6:
                num = 20;
                break;
            case 9:
                num = 30;
                break;
            default:
                num = 40;
        }
    }

    public void testException() {
        try {
            int a = 1 / 0; // 这将导致除以零的异常
        } catch (ArithmeticException e) {
            System.out.println("发生算术异常");
        }
    }

    public void syncBlockMethod() {
        synchronized (this) {
            // 同步块体
        }
    }
}
