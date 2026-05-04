package 循环;

public class Test {
    public static void main(String[] args) {
        Table table = new Table();
        table.insert(0,10);
        table.insert(0,10);
        table.insert(0,10);
        table.insert(0,10);
        System.out.println("table.isEmpty() = " + table.isEmpty());
        table.printList();

        table.popHead();
        table.popHead();
        table.insert(1,2);
        table.insert(1,2);
        table.printList();
    }
}
