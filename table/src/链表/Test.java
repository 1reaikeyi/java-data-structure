package 链表;

public class Test {
    public static void main(String[] args) {
        Table table = new Table();
        table.pushHead(1);
        table.pushHead(2);
        table.pushHead(3);
        table.pushHead(3);
        table.pushHead(3);
        table.printNode1();
//        System.out.println("---------------");
//        table.popHead();
//        table.popHead();
//        table.printNode1();
//        System.out.println("---------------");
//        boolean success = table.popBack();
//        System.out.println(success);
//        table.printNode1();
        table.insert(0,100);
        table.insert(1,200);
        table.printNode1();
        table.insert(2,300);
        table.printNode1();
        table.delete(0);
        table.delete(1);
        table.printNode2();
    }
}
