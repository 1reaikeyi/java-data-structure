package 单例2;

public class OneTest {
    public static void main(String[] args) {
        one a = one.get();
        one b = one.get();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
