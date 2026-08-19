package 双向;

public class Table {
    private static class Node {
      Node pre;
      int value;
      Node next;
      public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
      }

      public Node() {
      }

    }
    private Node head;
    private Node tail;
    public Table() {
        head = new Node(null,10000,tail);
        tail = new Node(head,11111,null);
        head.next = tail;
        tail.pre = head;
    }
    // 清空链表的方法
    public void clear() {
        head.next = tail;
        tail.pre = head;
    }
    // 判断链表是否为空的方法
    public boolean isEmpty() {
        return head.next == tail;
    }

    public boolean pushHead(int value){
        Node after = head.next;
        Node newNode = new Node(head,value,after);
        head.next = newNode;
        after.pre = newNode;
        return true;
    }
    private Node findIndex(int index) {
        Node p = head;
        for(int i = -1;p!=tail;p=p.next,i++){
            if(i==index){
                return p;
            }
        }
        return null;
    }
    public void insert(int index,int key){
        Node pre = findIndex(index-1);
        if (pre == null){
            throw new RuntimeException(index+"越界");
        }
        Node after = pre.next;
        Node newNode = new Node(pre,key,after);
        pre.next = newNode;
        after.pre = newNode;
    }


    public void delete(int index){
        Node p = findIndex(index-1);
        if (p == null||p.next == tail){
            throw new RuntimeException(index+"越界");
        }
        Node remove = p.next;
        Node next = remove.next;
        next.pre = p;
        p.next = next;
    }


   public void printNode(){
        Node cur = head.next;
        while(cur!=tail){
            System.out.println(cur.value);
            cur = cur.next;
        }
       System.out.println("---end");
   }


}
