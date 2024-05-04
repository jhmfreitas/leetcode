package blind75.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Recursive solution
    // Time Complexity: O(nlogK), K is the number of merged lists and N is the number of nodes
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;


        while (lists.length > 1) {
            List<ListNode> mergedList = new ArrayList();
            for (int i = 0; i < lists.length; i+=2) {
                ListNode l1 = lists[i];
                ListNode l2 = null;
                if (i+1 < lists.length) {
                    l2 = lists[i+1];
                }
                mergedList.add(mergeLists(l1, l2));
            }
            lists = mergedList.toArray(new ListNode[0]);
        }

        return lists[0];
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;

        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }

    // Min Heap Solution
    // Time Complexity: O(N*Mlog(N*M)) , N is the number of linked lists and M is the max size of a linked list
    // Adding a node to a min heap is O(logN)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> nodes = new PriorityQueue<>();

        for (ListNode node : lists) {
            while (node != null) {
                nodes.offer(node.val);
                node = node.next;
            }
        }

        if (nodes.isEmpty()) {
            return null;
        }

        ListNode head = new ListNode(nodes.poll());
        ListNode tail = head;
        while (!nodes.isEmpty()){
            Integer polled = nodes.poll();
            tail.next = new ListNode(polled);
            tail = tail.next;
        }

        return head;
    }
}
