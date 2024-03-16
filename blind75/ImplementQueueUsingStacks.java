package blind75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ImplementQueueUsingStacks {
    class MyQueue {

        Stack<Integer> stackInput;
        Stack<Integer> stackOutput;

        public MyQueue() {
            this.stackInput = new Stack<>();
            this.stackOutput = new Stack<>();
        }

        public void push(int x) {
            this.stackInput.push(x);
        }

        public int pop() {
            move();
            return this.stackOutput.pop();
        }

        public int peek() {
            move();
            return this.stackOutput.peek();
        }

        private void move() {
            if (this.stackOutput.isEmpty()) {
                while (!this.stackInput.isEmpty())
                    this.stackOutput.push(this.stackInput.pop());
            }
        }

        public boolean empty() {
            return Math.max(this.stackInput.size(), this.stackOutput.size()) == 0;
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
