package blind75.hard;

/**
 * This implementation is mine and it had a time limit exceeded but it is interesting
 *
 * The problem is only that I take to long to add a num -> O(N)
 * Using a heap allows to add it with O(logN) but the find median operation is O(1) in both cases
 */
public class FindMedianFromDataStreamLessEfficient {

    class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {
            this.val = val;
        }
    }

    Integer size = 0;
    Node head = new Node(Integer.MAX_VALUE);
    Node tail = new Node(Integer.MIN_VALUE);
    Node mid = tail;

    public MedianFinder() {
        head.prev = tail;
        tail.next = head;
    }

    public void addNum(int num) {
        Node node = new Node(num);
        Node aux = mid;
        size++;
        if (node.val < mid.val) {
            while (node.val < aux.val) {
                aux = aux.prev;
            }

            Node next = aux.next;
            next.prev = node;
            node.next = next;
            aux.next = node;
            node.prev = aux;

            if (size % 2 == 0) {
                mid = mid.prev;
            }

        } else {
            while (node.val >= aux.val) {
                aux = aux.next;
            }

            Node previous = aux.prev;
            previous.next = node;
            node.prev = previous;
            aux.prev = node;
            node.next = aux;

            if (size == 1) {
                mid = mid.next;
            } else if (size % 2 != 0) {
                mid = mid.next;
            }
        }
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (double) (mid.val + mid.next.val) / 2;
        } else {
            return mid.val;
        }
    }

    private void print() {
        Node t = tail;
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }

        System.out.println("Mid : " + mid.val);
    }
}
