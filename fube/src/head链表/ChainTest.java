package head链表;

public class ChainTest {
    public static void main(String[] args) {
        Chain list = new Chain();
        list.isEmpty();
//        list.addHead(1);
//        list.addHead(2);
//        list.addHead(3);
//        list.allPrint();
        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);
        list.addTail(5);
        list.allPrint();
//        list.popHead();
//        list.allPrint();
        list.popTail();
        list.allPrint();
    }
}
