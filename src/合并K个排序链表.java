import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并K个排序链表 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            Comparator comp = (Comparator<ListNode>) (node1, node2) -> node1.val - node2.val;
            PriorityQueue<ListNode> heap = new PriorityQueue<>(comp);
            for (ListNode node : lists) {
                if (node != null) {
                    heap.add(node);
                }
            }
            ListNode header = new ListNode(0), cur = header;
            while (!heap.isEmpty()) {
                ListNode min = heap.poll();
                cur.next = min;
                cur = min;
                if (min.next != null) {
                    heap.add(min.next);
                }
            }
            return header.next;
        }
    }
}
