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
        // 清空链表只需将哨兵节点的next指向null
        head.next = null;
    }

    public boolean isClear(){
        // 检查是否为空时看哨兵节点的next是否为null
        return head.next == null;
    }
    public boolean pushHead(int value){
        Node newNode = new Node(value,null);
        newNode.next = head.next;
        head.next = newNode;
        return true;
    }

    public Node findIndex(int index) {
        int a = -1;
        for (Node cur = head; cur != null; a++,cur = cur.next) {
            if (a == index) {
                return cur;
            }
        }
        return null;
    }

    public boolean insert(int index,int value){
        Node pre = findIndex(index - 1);
        if(pre == null){
            throw new RuntimeException(index+"越界");
        }
        Node newNode = new Node(value,pre.next);
        pre.next = newNode;
        return true;
    }
    public boolean delete(int index){
        Node pre = findIndex(index - 1);
        if(pre == null){
            throw new RuntimeException(index+"越界");
        }
        Node remove = pre.next;
        pre.next = remove.next;
        return true;
    }
    public void printNode1(){
        Node cur = head.next;
        while(cur != null){
            System.out.println(cur.value);
            cur = cur.next;
        }
        System.out.println("--- end");
    }
    public void printNode2(){
       for(Node cur = head.next; cur != null; cur = cur.next){
           System.out.println(cur.value);
       }
        System.out.println("---end");
    }
}
