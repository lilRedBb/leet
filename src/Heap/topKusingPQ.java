package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKusingPQ {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> freq.get(a) - freq.get(b)
        );

        for (int num : freq.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }

    public int[] topKFrequentMaxHeap(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> freq.get(b) - freq.get(a)
        );

        pq.addAll(freq.keySet());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
