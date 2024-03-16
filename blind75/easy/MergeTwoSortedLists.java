package blind75.easy;

public class MergeTwoSortedLists {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    // Polished solution with recursion
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    // First Solution with recursion
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;

        if(list1 == null) {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }

        if(list2 == null) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        }

        if (list1.val < list2.val) {
            return new ListNode(list1.val,mergeTwoLists(list1.next, list2));
        }

        if (list2.val < list1.val) {
            return new ListNode(list2.val,mergeTwoLists(list1, list2.next));
        }

        return new ListNode(list1.val, new ListNode(list2.val, mergeTwoLists(list1.next, list2.next)));
    }
}
