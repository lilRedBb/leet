package Heap;

import java.util.PriorityQueue;

public class KbigestByHeap215 {
    public int findKthLargest(int[] nums, int k) {
        // Min-Heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num); // Add the current number to the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if the heap size exceeds k
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}
