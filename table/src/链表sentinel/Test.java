package 链表sentinel;

public class Test {
    public static void main(String[] args) {
        Table table = new Table();
        table.addhead(1);
        table.addhead(2);
        table.addhead(3);
        table.add(0,10);
        table.add(0,10);
        table.add(0,10);
        table.printAll();
        table.del(0);
        table.printAll();

    }

}
