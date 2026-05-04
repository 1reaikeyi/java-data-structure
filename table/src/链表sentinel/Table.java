package 链表sentinel;

public class Table {
    private static class Node{
        int value;
        Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    private Node head = new Node(10000,null);
    public void toClear(){
        head.next = null; // 清空链表只需将哨兵节点的next指向null
    }

    public boolean isClear(){
        return head.next == null; // 检查是否为空时看哨兵节点的next是否为null
    }
    public void addhead(int value){
        Node newNode = new Node(value,null);
        newNode.next = head.next;
        head.next = newNode;
    }
    public void printAll(){
        Node cur = head.next;
        while(cur != null){
            System.out.print(cur.value);
            System.out.print("\t");
            cur = cur.next;
        }
        System.out.println();
        System.out.println("####################");
    }
    public Node findIndex(int index) {
        int a = -1;
        // 从第一个数据节点开始遍历
        for (Node cur = head; cur != null; cur = cur.next) {
            if (a == index) {
                return cur;
            }
            a++;
        }
        System.out.println("索引范围0到"+a+"\n");
        return null;
    }
    public void add(int x,int value){
        Node pre = findIndex(x-1);
        if(pre == null){
            throw new RuntimeException(String.format("index:%d不合法", x));
        }
        Node newNode = new Node(value,pre.next);
        pre.next = newNode;

    }
    public void del(int x){
        Node pre = findIndex(x-1);
        if(pre == null){
            throw new RuntimeException(String.format("index:%d不合法", x));
        }
        /**
         *      pre  cur next
         *      1    2   3
         *      1    3
         *      pre.next = pre.next.next
         */
        pre.next = pre.next.next;
    }

}
