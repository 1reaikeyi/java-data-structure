package 双向表;

public class test {
    public static void main(String[] args) {
        Table table = new Table();

        table.addHead(1);
        table.addHead(10);
        table.addHead(100);
        table.addHead(1);
        table.addHead(10);
        table.addHead(100);

        table.kai();
        System.out.println("table.isEmpty() = " + table.isEmpty());
        table.popHead();
        table.popHead();
        table.popHead();
        table.kai();
        table.clear();
        table.addBack(1);
        table.addBack(10);
        table.addBack(100);
        System.out.println("table.isEmpty() = " + table.isEmpty());
        table.kai();
        table.clear();
        table.insert(0,1);
        table.insert(0,1);
        table.insert(2,1);
        table.kai();
    }
}
