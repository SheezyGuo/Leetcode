public class 翻转m到n的链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode header = new ListNode(-1);
        header.next = head;
        int count = 0;
        ListNode pre = null, cur = header, next = null, leftTail = null, rightHead = null, midTail = null;
        while (count < m) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        leftTail = pre;
        pre = null;
        midTail = cur;
        while (count <= n) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count++;
        }
        rightHead = next;
        leftTail.next = pre;
        midTail.next = rightHead;
        return header.next;
    }

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode head = reverseBetween(n1, 2, 4);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }


}
