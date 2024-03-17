package blind75.easy;



public class MiddleOfLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Naive Solution
    public ListNode middleNode(ListNode head) {
        int length = 0;

        ListNode headRef = head;
        // find list length
        while (head != null) {
            head = head.next;
            length++;
        }

        int halfLength = length/2 + 1;
        // print middle node
        int aux = 1;
        while (headRef != null){
            if (aux == halfLength)
                return headRef;
            headRef = headRef.next;
            aux++;
        }

        return null;
    }

    //Efficient Solution
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
