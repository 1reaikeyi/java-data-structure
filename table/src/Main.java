public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        int c = b;
        System.out.println("a的地址："+a);//10
        System.out.println("b的地址："+b);//10
        System.out.println("c的地址："+c);//10
        b = 20;
        System.out.println("a的地址："+a);//10
        System.out.println("b的地址："+b);//20
        System.out.println("c的地址："+c);//10
        System.out.println("=======================");
        int[] a1 = {10};
        int[] b1 = a1;
        int[] c1 = b1;
        System.out.println("a1 = " + a1);//10
        System.out.println("b1 = " + b1);//10
        System.out.println("c1 = " + c1);//10
        b1 = new int[1];
        System.out.println("a1 = " + a1.toString());//10
        System.out.println("b1 = " + b1.toString());//0
        System.out.println("c1 = " + c1.toString());//10
    }
}
