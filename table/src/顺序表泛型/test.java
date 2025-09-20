package 顺序表泛型;

public class test {
    public static void main(String[] args) {
       Node<Object> list = new Node<>();
       list.insert(0,1);
       list.insert(1,'a');
       list.printList();
       list.delete(0);
       list.printList();
    }

}
