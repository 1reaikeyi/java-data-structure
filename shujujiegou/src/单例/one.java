package 单例;

public class one {
    private one() {
    }
    // 初始化静态变量 me
    private static one me = new one();

   public static one get() {
        return me;
    }

    String name = "one";

}
