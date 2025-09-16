package 重写;

public class Chongxie {
    public static void main(String[] args) {

    }




    public static void add(int a,int b){

    }
    //个数不一样
    public static void add(int a,int b,int c){

    }
    // 编译错误
//    public static int add(int a,int b){
//        return 0;
//    }
    //类型不一样
    public static void add(double a,double b) {

    }
    // 编译错误
//    public static void add(int c,int d){}
    //顺序不一样
    public static void add(double a,int b){

    }
}
