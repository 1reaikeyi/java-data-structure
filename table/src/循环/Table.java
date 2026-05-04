package 循环;

public class Table {
    private static class Node{
        Node pre;
        int value;
        Node next;
        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
    private int size;
    private Node sentinel;

    public Table() {
        size = 0;
        sentinel = new Node(null,10000,null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }
    public void clear(){
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }
    public boolean isEmpty(){
        return sentinel.next == sentinel||sentinel.pre == sentinel;
    }
    public void addHead(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node newNode = new Node(a,value,b);
        a.next = newNode;
        b.pre = newNode;
        size++;
    }
    public void addLast(int value){
        Node a = sentinel.pre;
        Node b = sentinel;
        Node newNode = new Node(a,value,b);
        a.next = newNode;
        b.pre = newNode;
        size++;
    }

    public Node findIndex(int index){
//        if (sentinel.next == sentinel){
//            System.out.println("链表为空");
//        }

        if (index == -1) {
            return sentinel;
        }
        int i = -1;
        for (Node p = sentinel.next;p!=sentinel;i++,p = p.next){
            if (i == index){
                return p;
            }
        }
        return null;
    }
    public void insert(int index,int value){
        Node pre = findIndex(index-1);
        if (pre == null){
            throw new RuntimeException(String.format("index:%d不合法", index));
        }

        Node next = pre.next;
        Node newNode = new Node(pre,value,next);
        pre.next = newNode;
        next.pre = newNode;
        size++;
    }
    public void remove(int index){
        Node pre = findIndex(index-1);
        if (pre == null){
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        Node remove = pre.next;
        Node newNode = remove.next;
       pre.next = newNode;
        newNode.pre = pre;
        size--;
    }

    public void popHead(){
        if (sentinel.next == sentinel){
            throw new RuntimeException("链表为空");
        }
        Node remove = sentinel.next;
        Node c = remove.next;
        sentinel.next = c;
        c.pre = sentinel;
        size--;
    }
    public void popLast(){
        if (sentinel.next == sentinel){
            throw new RuntimeException("链表为空");
        }
        Node a = sentinel.pre;
        Node b = a.pre;
        sentinel.pre = b;
        b.next = sentinel;
        size--;
    }
    public void printList(){
        if (sentinel.next == sentinel||sentinel.pre == sentinel){
            System.out.println("链表为空");
            return;
        }
        Node a = sentinel.next;
        while (a!=sentinel){
            System.out.print(a.value+"\t");
            a = a.next;
        }
        System.out.println("size = "+size);
    }
    public void popValue(int value){
        Node pre = sentinel;
        for (Node p = sentinel.next;p!=sentinel;p = p.next){
            if (p.value == value){
                pre.next = p.next;
                p.next.pre = pre;
                size--;
                return;
            }
            pre = p;
        }
    }
}
