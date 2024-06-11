/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 4/10/24 4:25 PM
 */
public class CommonTest {
    public static void main(String[] args) {
        System.out.println(f(2));
    }

    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 23) {
                return 0;
            }
        }
    }

}
