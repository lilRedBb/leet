package linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRU146 {
    private class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRU146(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() == capacity) {
                Node tailPrev = tail.prev;
                cache.remove(tailPrev.key);
                removeNode(tailPrev);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
        }
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }



    public static void main(String[] args) {
        LRU146 lruCache = new LRU146(3);

        // Test 1: Basic put and get
        lruCache.put(1, 100);
        lruCache.put(2, 200);
        lruCache.put(3, 300);
          // Should print 200
        printCacheState(lruCache);

        assert lruCache.get(1) == 1000 : "Test 1 Failed: Expected value 100 for key 1";
        assert lruCache.get(2) == 200 : "Test 1 Failed: Expected value 200 for key 2";
        assert lruCache.get(3) == 300 : "Test 1 Failed: Expected value 300 for key 3";


        // Test 2: Update existing key and check order
        lruCache.put(2, 250);
        System.out.println("Get 2 after update (expected 250): " + lruCache.get(2));  // Should print 250
        printCacheState(lruCache);

        // Test 3: Exceeding capacity
        lruCache.put(4, 400);  // This should evict the least recently used key (which is key 1)
        System.out.println("Get 1 (expected -1): " + lruCache.get(1));  // Should print -1 since key 1 is evicted
        printCacheState(lruCache);

        // Test 4: Access order changing LRU order
        lruCache.get(3);  // Access key 3 so it becomes most recently used
        lruCache.put(5, 500);  // This should evict key 4 now (if key 4 was the least recently used)
        System.out.println("Get 4 (expected -1): " + lruCache.get(4));
        printCacheState(lruCache);
    }

    private static void printCacheState(LRU146 cache) {
        // Assuming you add a method to access the linked list from head to tail for debugging purposes.
        // You might need to add a method in LRU146 to expose the current state for debugging.
        Node current = cache.head.next;
        System.out.print("Cache state: ");
        while (current != cache.tail) {
            System.out.print("[" + current.key + ":" + current.value + "] ");
            current = current.next;
        }
        System.out.println();
    }

}
