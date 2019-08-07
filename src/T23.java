import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T23 {

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
            Comparator comp = new Comparator<ListNode>() {
                @Override
                public int compare(ListNode node1, ListNode node2) {
                    return node1.val - node2.val;
                }
            };
            PriorityQueue<ListNode> heap = new PriorityQueue<>();
            heap.addAll(Arrays.asList(lists));
            ListNode header = new ListNode(0), cur = header;
            while (!heap.isEmpty()) {
                ListNode min = heap.poll();
                if (min != null) {
                    cur.next = min;
                    cur = min;
                    if (min.next != null) {
                        heap.add(min.next);
                    }
                }
            }
            return header.next;
        }
    }
}
