package blind75.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> smallElements;
    PriorityQueue<Integer> largeElements;

    public MedianFinder() {
        // This needs to be a maxHeap for the largest lowest element to stay in the root
        smallElements = new PriorityQueue<>(Collections.reverseOrder());
        largeElements = new PriorityQueue<>();
    }

    public void addNum(int num) {
        smallElements.add(num);

        if (!smallElements.isEmpty() && !largeElements.isEmpty() && smallElements.peek() > largeElements.peek()) {
            Integer polled = smallElements.poll();
            largeElements.add(polled);
        }

        if (smallElements.size() > largeElements.size() + 1) {
            Integer polledElement = smallElements.poll();
            largeElements.add(polledElement);
        }

        if (largeElements.size() > smallElements.size() + 1) {
            Integer polledElement = largeElements.poll();
            smallElements.add(polledElement);
        }
    }

    public double findMedian() {
        if (smallElements.size() == largeElements.size()) {
            return (double) (smallElements.peek() + largeElements.peek()) /2;
        } else if (largeElements.size() < smallElements.size()) {
            return smallElements.peek();
        } else {
            return largeElements.peek();
        }
    }
}
