package 链表;

import java.util.function.Consumer;

public class Table {
    private static class Node{
        int value;
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

    public boolean pushHead(int value){
        if (head == null){
            head = new Node(value,null);
            return true;
        }
        Node newNode = new Node(value,null);
        newNode.next = head;
        head = newNode;
        return true;
    }

    public boolean pushBack(int value){
        if(head == null){
            pushHead(value);
            return true;
        }
        Node p = head;
        while (p.next!=null){
            p = p.next;
        }
        p.next = new Node(value,null);
        return true;
    }

    public Node findIndex(int value){
        if (this.isEmpty()){
            System.out.println("链表为空");
        }
        int a = 0;
        for (Node p = head;p.next !=null;a++,p = p.next){
            if(a == value){
                return p;
            }
        }
        return null;
    }

    public int getValue(int index){
        Node get = findIndex(index);
        if (get == null) {
            throw new RuntimeException(index+"越界");
        }
        return get.value;
    }

    public boolean popHead(){
        if (this.isEmpty()){
            System.out.println("链表为空");
            return false;
        }
        head = head.next;
        return true;
    }

    public boolean popBack(){
        if (this.isEmpty()){
            System.out.println("链表为空");
            return false;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        // 移除尾节点
        cur.next = null;
        return true;
    }

    public boolean insert(int index,int key){
        if(index == 0){
            pushHead(key);
            return true;
        }
        Node node = findIndex(index - 1);
        if (node == null) {
            throw new RuntimeException(index+"越界");
        }
        Node newnode = new Node(key, node.next);
        node.next = newnode;
        return true;
    }

    public boolean delete(int index){
        if (this.isEmpty()){
            System.out.println("链表为空");
            return false;
        }
        if(index == 0){
            popHead();
            return true;
        }
        Node node = findIndex(index -1);
        if (node == null){
            throw new RuntimeException(index+"越界");
        }
        Node remove = node.next;
        node.next = remove.next;
        return true;
    }
    public void printNode1() {
        for (Node p = head; p != null; p = p.next) {
            System.out.println(p.value);
        }
        System.out.println("--- end");
    }
    public void printNode2() {
        Node p = head;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
        System.out.println("---end");
    }



}
