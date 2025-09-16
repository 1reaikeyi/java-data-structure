package head链表;

public class Chain {
    /**
     * 节点类
     *         []      []       []       []     null
               |       |        |        |      |
             head
             cur
     */
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    Node head = null;
    public boolean isEmpty(){
        if(head == null ){
            System.out.println("链表为空null");
            return true;
        }else {
            System.out.println("链表不为空");
            return false;
        }
    }

    public void allPrint(){
         isEmpty();
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + "\t");
            cur = cur.next;

        }
        System.out.println(" ");
        System.out.println("---------------\n");
    }
    public void allprint(){
        for(Node cur = head;cur !=null;cur = cur.next){
            System.out.print(cur.value + "\t");
        }
        System.out.println(" ");
        System.out.println("---------------\n");
    }

    public void addHead(int value){
        //创建新节点
        Node newNode = new Node(value, head);
       // newNode-->head
        //将头节点指向新节点
        head = newNode;
        //head-->newNode
    }
    public void addTail(int value){
        if(head == null){
            addHead(value);
            return;
        }
        Node cur = head;
        while(cur.next !=null){
            cur = cur.next;
        }
        Node newNode = new Node(value, cur.next);
        cur.next = newNode;

    }
    public  void popHead(){
        if(head == null){
            throw new RuntimeException("链表为空");
        }
        head = head.next;
    }
    public  void popTail(){
        if(head == null){
            throw new RuntimeException("链表为空");
        }
        Node cur = head;
        // 处理链表只有一个节点的情况
        if (head.next == null) {
            head = null; // 直接将head置为null，链表变为空
            return;
        }

        while (cur.next.next != null){
            cur = cur.next;
        }
        Node pre = cur.next;
        pre = null;
        cur.next = pre;

        /**
         *              []      []       []       last         null
         *              |       |        |        |             |
         *                              cur      cur.next      cur.next.next
         *                                       pre
         *
         */

    }
    public Node fingIndex(int index){
        if(index < 0 ){
            throw new RuntimeException("索引不合法");
        }
        int a = 0;
        for(Node cur = head;cur != null;cur = cur.next){
            if( a == index){
                return cur;
            }
            a++;
        }
        return null;
    }
    public void addIndex(int index,int value){

    }

}
