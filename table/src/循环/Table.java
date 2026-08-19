package 循环;

public class Table {
    private static class Node{
        int value;
        Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
        }
    }
    private Node sentinel;

    public Table() {
        sentinel = new Node(10000,null);
        sentinel.next = sentinel;
    }
    public void clear(){
        sentinel.next = sentinel;

    }
    public boolean isEmpty(){
        return sentinel.next == sentinel;
    }
    public boolean pushHead(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node newNode = new Node(value,b);
        a.next = newNode;
        return true;
    }

    public Node findIndex(int index){
        if (this.isEmpty()){
            System.out.println("链表为空");
        }
        int i = -1;
        for (Node p = sentinel.next;p!=sentinel;i++,p = p.next){
            if (i == index){
                return p;
            }
        }
        return null;
    }
    public boolean insert(int index,int value){
        Node pre = findIndex(index-1);
        if (pre == null){
            throw new RuntimeException(index+"越界");
        }
        Node next = pre.next;
        Node newNode = new Node(value,next);
        pre.next = newNode;
        return true;
    }
    public boolean delete(int index){
        Node pre = findIndex(index-1);
        if (pre == null){
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        Node remove = pre.next;
        Node newNode = remove.next;
        pre.next = newNode;
        return true;
    }
    public void printNode(){
        if (this.isEmpty()){
            System.out.println("链表为空");
            return;
        }
        Node a = sentinel.next;
        while (a!=sentinel){
            System.out.println(a.value);
            a = a.next;
        }

    }
    public void popValue(int value){
        Node pre = sentinel;
        for (Node p = sentinel.next;p!=sentinel;p = p.next){
            if (p.value == value){
                pre.next = p.next;
                return;
            }
            pre = p;
        }
    }
}
