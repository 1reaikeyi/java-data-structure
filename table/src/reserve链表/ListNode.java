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
        ListNode newNode =null;
        while (head != null) {
            //newNode { val = 1, next = null }
            //newNode { val = 2, next = { val = 1, next = null } }
            //newNode { val = 3, next = { val = 2, next = { val = 1, next = null } } }
            //newNode { val = 4, next = { val = 3, next = { val = 2, next = { val = 1, next = null } } } }
            //newNode { val = 5, next = { val = 4, next = { val = 3, next = { val = 2, next = { val = 1, next = null } } } } }
           newNode = new ListNode(head.val, newNode);
           System.out.println("newNode = " + newNode.val);
            head = head.next;

       }
        return newNode;
    }
    //方法二
    public ListNode reverseList2(ListNode p) {
        if(p.next == null||p == null){
            return p;
        }
        ListNode last = reverseList2(p.next);
        System.out.println("last = " + last);
        p.next.next = p;
        p.next = null;
        return last;
    }
    //方法三
}