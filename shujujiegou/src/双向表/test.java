package 双向表;

public class test {
    public static void main(String[] args) {
        表 table = new 表();
        table.insert(0,1);
        table.insert(1,2);
        table.pushHead(6);
        table.pushHead(6);
        table.pushHead(6);
        table.popHead();
        table.popHead();
        table.popHead();
        table.popHead();
        table.popHead();
//        table.popHead();
        System.out.println("table.isEmpty() = " + table.isEmpty());
        table.kai();
        table.clear();
    }
}
