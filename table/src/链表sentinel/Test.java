package 链表sentinel;

public class Test {
    public static void main(String[] args) {
        Table table = new Table();
        table.pushHead(1);
        table.pushHead(1);
        table.pushHead(1);
        table.printNode1();
        table.insert(0,0);
        table.insert(1,10);
        table.insert(2,100);
        table.printNode2();
    }

}
