package list;

public class Test {
    public static void main(String[] args) {
        usee node = new Node();
        node.isEmpty();
        node.kai();
        node.add(1, 1);
        node.add(2, 2);
        node.add(3, 3);
        node.kai();
        node.isEmpty();
        node.findIndex(1);
        node.findIndex(2);
        node.findIndex(3);
        node.findIndex(4);
        int a = node.get(3);
        int b = node.get(2);
        int c = node.get(3);
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("c:" + c);
        node.set(3, 100);
        node.kai();
        node.remove(1);
        node.kai();
    }
}
