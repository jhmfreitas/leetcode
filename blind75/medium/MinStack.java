package blind75.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MinStack {

    // Two stack solution
    Deque<Integer> stack = new ArrayDeque<Integer>();
    Deque<Integer> minStack = new ArrayDeque<Integer>();

    public MinStack() {

    }

    public void push(int val) {
        int min = Math.min(minStack.peek() != null ? minStack.peek() : Integer.MAX_VALUE, val);
        stack.push(val);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // Linked List solution

    public class Node {
        int min;
        int val;
        Node next;

        public Node() {

        }
    }

    Node root;

    public MinStack() {

    }

    public void push(int val) {
        Node node = new Node();
        node.val = val;

        int min = val;
        if(root != null) {
            min = Math.min(root.min, val);
        }

        node.next = root; // The next is the element below in the stack
        node.min = min;
        root = node;
    }

    public void pop() {
        root = root.next;
    }

    public int top() {
        return root.val;
    }

    public int getMin() {
        return root.min;
    }
}
