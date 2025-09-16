package head链表;


import java.util.function.Consumer;

public class table {
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node head = null;

    /**
     *    head----------------------->node1
     *       |>--------node2------------|
     * @param value
     */
    public void pushHead(int value) {

       //第一个
        head = new Node(value, null);
        //第二个
        head  = new Node(value, head);

    }

    public void pushBack(int value) {
        if (head == null) {
            head = new Node(value, head);
        } else {
            // 找到链表的尾部节点
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            // 在尾部添加新节点
            cur.next = new Node(value, null);
        }
    }

    public boolean isClear() {
        if (head == null) {
            System.out.println("链表为空");
        }
        return true;

    }

    public void clear() {
        head = null;
        System.out.println("链表为空");
    }


    public void popHead() {
        if (head == null) {
            throw new RuntimeException("链表为空");
        }
        head = head.next;
    }

    public void popBack() {
        if (head == null) {
            throw new RuntimeException("链表为空");
        }
        if (head.next == null) {
            popHead();
            return;
        }
        Node cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

    public Node findIndex(int index) {
        int a = 0;
        for (Node p = head; p != null; p = p.next, a++) {
            if (a == index) {
                return p;
            }
        }
        return null;

    }

    public int get(int index) {
        Node p = findIndex(index);
        if (p == null) {
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        return p.value;
    }

    public void insert(int index, int key) {

        if (index == 0) {
            pushHead(key);
            return;
        }
        Node prevalue = findIndex(index - 1);
        if (prevalue == null) {
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        Node newNode = new Node(key, prevalue.next);
    }

    public void remove(int index) {

        if (index == 0) {
            popHead();
            return;
        }
        Node prevalue = findIndex(index - 1);
        if (prevalue == null) {
            throw new RuntimeException(String.format("index:%d不合法", index));
        }
        Node removeNode = prevalue.next;
        prevalue.next = removeNode.next;
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
