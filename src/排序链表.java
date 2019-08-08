public class 排序链表 {


    //Definition for singly-linked list.
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = part(head), head2 = mid.next;
        mid.next = null;
        ListNode part1 = sortList(head), part2 = sortList(head2);
        ListNode first = merge(part1, part2);
        return first;
    }

    private ListNode part(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        } else if (n2 == null) {
            return n1;
        }
        ListNode header = new ListNode(0), tail = header;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                tail.next = n1;
                tail = tail.next;
                n1 = n1.next;
            } else {
                tail.next = n2;
                tail = tail.next;
                n2 = n2.next;
            }
        }
        while (n1 != null) {
            tail.next = n1;
            tail = tail.next;
            n1 = n1.next;
        }
        while (n2 != null) {
            tail.next = n2;
            tail = tail.next;
            n2 = n2.next;
        }
        return header.next;
    }

    public static void main(String[] args) {
        排序链表 排序链表 = new 排序链表();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        ListNode h = 排序链表.sortList(n1);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

}
