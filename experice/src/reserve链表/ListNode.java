package reserve链表;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        sb.append(val);
        ListNode current = this.next;
        while (current != null) {
            sb.append(", "); // 添加分隔符，使输出更易读
            sb.append(current.val);
            current = current.next; // 关键：移动到下一个节点
        }
        sb.append("]");
        return sb.toString();
    }
//    方法一
    public ListNode reverseList(ListNode head) {
        int a = 0;
        ListNode newHead;
        while (head.next != null) {
            head = head.next;
            newHead = head.next;
            a++;
        }
        System.out.println("数据个数： = " + a);


        return head;
    }
}