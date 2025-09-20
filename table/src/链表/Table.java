package 链表;

import java.util.function.Consumer;

public class Table {
    private static class Node{
        public int value;
        Node next;

        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
    }
    Node head = null;

    public void Clear(){
        head =null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void pushHead(int value){
        if (head == null){
            head = new Node(value,null);
            return;
        }
        Node newNode = new Node(value,head);
        head = newNode;
    }

    public void pushBack(int value){
        if(head == null){
            pushHead(value);
        }
        Node p = head;
        while (p!=null){
            p = p.next;
        }
        p.next = new Node(value,null);
    }

    public Node findIndex(int index){
        if (head == null){
            System.out.println("链表为空");
        }
        int a = 0;
        for (Node p = head;p !=null;a++,p = p.next){
            if(a == index){
                return p;
            }
        }
        return null;
    }

    public int get(int index){
        index -=1;
        Node get = findIndex(index);
        if (get == null) {
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        return get.value;
    }

    public void popHead(){
        if (head == null){
            System.out.println("链表为空");
            return;
        }
        head = head.next;
    }

    public void popBack(){
        if (head == null){
            System.out.println("链表为空");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        // 移除尾节点
        cur.next = null;

    }

    public void insert(int index,int key){
        if(index == 0){
            pushHead(key);
        }

        Node prevalue = findIndex(index - 1);
        if (prevalue == null) {
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        Node newNode = new Node(key, prevalue.next);
    }

    public void popIndex(int index){
        if(index == 0||head ==null){
            popHead();
            return;
        }
        Node pre = findIndex(index-1);

        if (pre == null){
            throw new RuntimeException(String.valueOf(index+"不合法"));
        }
        Node remove = pre.next;
        pre.next = remove.next;

    }
    public void allPrint1() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + "\t");
            cur = cur.next;
        }
        System.out.println("---------------\n");
    }


    //for循环
    public void allPrint2() {
        for (Node p = head; p != null; p = p.next) {
            System.out.println(p.value);
        }
    }
    //迭代lambal
    public void allPrint3(Consumer<Integer> data) {
        Node cur = head;
        while (cur != null) {
            data.accept(cur.value);
            cur = cur.next;
        }
    }


}
