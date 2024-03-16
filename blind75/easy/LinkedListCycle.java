package blind75.easy;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

/*public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    boolean res = false;
    while (slow != null) {
        slow = slow.next;
        fast = fast != null ? fast.next : null;
        if(fast != null) {
            fast = fast.next;
        }

        if (slow != null && fast != null && slow == fast) {
            res = true;
            break;
        }
    }

    return res;
}*/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if(slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
