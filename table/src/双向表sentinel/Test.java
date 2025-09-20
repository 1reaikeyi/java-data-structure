package 双向表sentinel;

public class Test {
    public static void main(String[] args) {
        Table table = new Table();
        table.insert(0,10);
        table.insert(0,10);
        table.insert(0,10);
        table.insert(0,10);
        System.out.println("table.isClear() = " + table.isClear());
        table.printList();
//        table.clear();
        table.popHead();
        table.popHead();
        table.insert(1,2);
        table.insert(1,2);
        table.printList();
    }
}
