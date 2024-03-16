package blind75.easy;

public class ReverseLinkedList {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Iterative Solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }

    // Recursive Solution
    public ListNode reverseList(ListNode head) {
        // Base case: if the list is empty or has only one node, return it as is
        if (head == null || head.next == null)
            return head;

        // Reverse the rest of the list recursively
        ListNode reversed = reverseList(head.next);

        // Adjust pointers to reverse the current node
        head.next.next = head;
        head.next = null;

        // Return the new head of the reversed list
        return reversed;
    }


}
