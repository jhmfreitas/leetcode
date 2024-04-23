package blind75.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DoublyLinkedListNode{
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        Integer key;
        Integer value;

        public DoublyLinkedListNode(){}

        public DoublyLinkedListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DoublyLinkedListNode> cache = new HashMap<>();
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoublyLinkedListNode();
        tail = new DoublyLinkedListNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        DoublyLinkedListNode node = cache.get(key);
        moveNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoublyLinkedListNode node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            node.value = value;
            cache.put(key, node);
        } else {
            if (size == capacity) {
                evictOldest();
                size--;
            }
            node = new DoublyLinkedListNode(key, value);
            cache.put(key, node);
            size++;
        }

        moveNodeToHead(node);
    }

    private void evictOldest() {
        DoublyLinkedListNode lru = tail.prev;
        DoublyLinkedListNode nextLru = lru.prev;
        tail.prev = nextLru;
        nextLru.next = tail;
        cache.remove(lru.key);
    }

    private void moveNodeToHead(DoublyLinkedListNode node) {
        DoublyLinkedListNode nodePrev = node.prev;
        DoublyLinkedListNode nodeNext = node.next;

        if (nodePrev != null) {
            nodePrev.next = nodeNext;
        }

        if (nodeNext != null) {
            nodeNext.prev = nodePrev;
        }

        DoublyLinkedListNode previousMru = head.next;
        head.next = node;
        node.prev = head;
        node.next = previousMru;
        previousMru.prev = node;
    }
}
