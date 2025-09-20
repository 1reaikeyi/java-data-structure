package 顺序表;

public class test {
    public static void main(String[] args) {
        Node list = new Node(0);
        list.addHead(1);
        list.addHead(2);
        list.addHead(3);
        list.printList();
        list.add(5,100);
        list.add(5,100);
        list.add(5,100);
        list.printList();
//        list.remove(0);
//        list.remove(1);
//        list.printList();
//        list.remove(0);
//        list.printList();
//        System.out.println("--------------");
//        list.add(0,1);
//        list.add(1,2);
//        list.add(2,3);
//        list.add(0,1);
//        list.printList();
//        list.pop(1);
//        list.printList();
//        list.pop(1);
//        list.printList();
//        int temt = list.get(4);
//        System.out.println(temt);

    }
}
