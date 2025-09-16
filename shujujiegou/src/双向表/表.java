package 双向表;

public class 表 {
    private static class Node {
      Node pre;
      int value;
      Node next;
        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
    private int size = 0;
    private Node head;
    private Node tail;
    public 表() {
        head = new Node(null,0,null);
        tail = new Node(null,10000,null);
        head.next = tail;
        tail.pre = head;
    }
    // 清空链表的方法
    public void clear() {
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    // 判断链表是否为空的方法
    public boolean isEmpty() {
        return head.next == tail;
    }
    private Node findIndex(int index) {
        int i = -1;
        for(Node p = head;p!=tail;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }
    public void insert(int index,int key){
        Node pre = findIndex(index-1);
        if (pre == null){
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        Node next = pre.next;
        Node newNode = new Node(pre,key,next);
        pre.next = newNode;
        next.pre = newNode;
        size++;
    }
    public void pushHead(int value){
        insert(0,value);
    }
    public void pushBack(int value){
//        insert(size,value);
        Node prelast = tail.pre;
        prelast.next = new Node(prelast,value,tail);
        tail.pre = prelast.next;
        size++;
    }
    public void remove(int index){
        Node p = findIndex(index-1);

        if (p == null||p.next == tail){
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        //      p  remoce  next
        Node remove = p.next;
        //      p---(remoce)---next
        Node next = remove.next;
        next.pre = p;
        p.next = next;
        size--;
    }
    public void popHead(){
       remove(0);

    }
    public void popBack(){
//        remove(size-1);
        Node prelast = tail.pre;
        prelast.pre.next = tail;
        tail.pre = prelast.pre;
        size--;

    }
   public  void kai(){
        Node cur = head.next;
        while(cur!=tail){
            System.out.println(cur.value);
            cur = cur.next;
        }
       System.out.println("size = " + size);
       System.out.println("--------------------------");
   }


}
