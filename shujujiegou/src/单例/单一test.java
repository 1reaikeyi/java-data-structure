package 单例;

public class 单一test {

        public static void main(String[] args) {
            one a = one.get();
            one b = one.get();
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println(a == b);
            System.out.println("a.name = " + a.name);
            a.name = "张三";
            System.out.println("a.name = " + a.name);
            System.out.println("b.name = " + b.name);
        }
}
