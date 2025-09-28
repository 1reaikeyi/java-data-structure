package 链表;

import java.util.Iterator;

public class Table<T> implements Queue<T>,Iterable<T>{
    private static class Node<T>{
        T value;
        Node<T> next;
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    Node<T> head = new Node<T>(null,null);
    Node<T> tail = head;
    private int size = 0;
    private int capacity = 0;
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){

            Node<T> cur = head;
            @Override
            public boolean hasNext() {
                return cur.next != null;
            }

            @Override
            public T next() {
                cur = cur.next;
                T value = cur.value;
                return value;
            }
        };
    }

    public Table(int capacity) {
        this.capacity = capacity;
        tail.next = head;
    }

    public Table() {
//       this.head = new Node<T>(null,null);
        tail.next = head;
    }

    @Override
    public boolean offer(T value) {
        if (isFull()) {
            return false;
        }
        // 创建新节点，next为null（因为要放在队列尾部）
        Node<T> newNode = new Node<T>(value, null);

        // 将新节点链接到当前tail节点之后
        tail.next = newNode;

        // 更新tail指针指向新的尾部节点
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public T pull() {
        if (isEmpty()) {
            return null;
        }

        // 获取头部的实际元素节点
        Node<T> firstNode = head.next;
        // 将head.next指向下一个节点，移除第一个元素
        head.next = firstNode.next;

        // 如果移除后队列为空，需要更新tail指向head
        if (firstNode == null) {
            tail = head;
        }
        size--;
        return firstNode.value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }
    public void printAll(){
        Node<T> cur = head.next;
        while(cur!= null){
            System.out.print(cur.value);
            System.out.print("\t");
            cur = cur.next;
        }
        System.out.println();

    }
}
