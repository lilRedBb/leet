package Queue;


import java.util.PriorityQueue;

public class PQ {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the PriorityQueue
        pq.add(4);
        pq.add(2);
        pq.add(5);
        pq.add(1);
        pq.add(3);

        // The elements will be ordered based on their natural ordering (smallest first)
        System.out.println("PriorityQueue: " + pq);

        // Removing elements from the PriorityQueue
        while (!pq.isEmpty()) {
            System.out.println("Polling element: " + pq.poll());
        }
    }

}
