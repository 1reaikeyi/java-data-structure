package 顺序表;

public class test {
    public static void main(String[] args) {
       Node<Object> list = new Node<>();
       list.insert(0,1);
       list.insert(1,'a');
       list.insert(1,'b');
       list.insert(1,'c');
       list.insert(1,'d');
       list.printList();
       list.delete(0);
       list.printList();
    }

}
