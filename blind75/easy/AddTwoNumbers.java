package blind75.easy;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addLists(l1, l2, 0);
    }

    private ListNode addLists(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return (carry == 0) ? null : new ListNode(carry);
        }

        int sum = carry;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;

        ListNode result = new ListNode(sum % 10);
        result.next = addLists((l1 != null) ? l1.next : null, (l2 != null) ? l2.next : null, sum / 10);

        return result;
    }
}
