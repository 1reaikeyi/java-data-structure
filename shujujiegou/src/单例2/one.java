package 单例2;

public class one {
    private one() {

    }
    // 初始化静态变量 me
    private static one me;
    public static one get() {
        if (me == null) {
            me = new one();

        }
        System.out.println("唯一性");
        return me;
    }
}
