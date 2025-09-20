package 双向表sentinel;

public class 表 {
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
    public 表() {
        size = 0;
        sentinel = new Node(null,-100,null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }
    public void addFirst(int value){
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
    public void clear(){
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }
    public boolean isClear(){
        return sentinel.next == sentinel||sentinel.pre == sentinel;
    }
    public void removeFirst(){
        if (sentinel.next == sentinel){
            throw new RuntimeException("链表为空");
        }
        Node a = sentinel.next;
        Node b = a.next;
        sentinel.next = b;
        b.pre = sentinel;
        size--;
    }
    public void removeLast(){
        if (sentinel.next == sentinel){
            throw new RuntimeException("链表为空");
        }
        Node a = sentinel.pre;
        Node b = a.pre;
        sentinel.pre = b;
        b.next = sentinel;
        size--;
    }
    public void kai(){
        if (sentinel.next == sentinel){
            System.out.println("链表为空");
            return;
        }
        Node a = sentinel.next;
        while (a!=sentinel){
            System.out.println(a.value);
            a = a.next;
        }
    }
    public Node findIndex(int index){
        if (sentinel.next == sentinel){
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
    public void insert(int index,int value){
        Node pre = findIndex(index-1);
        if (pre == null){
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        //   pre
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
        pre.next = remove.next;
        remove.next.pre = pre;
        size--;
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
