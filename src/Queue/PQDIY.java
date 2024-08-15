package Queue;
import java.util.Arrays;
public class PQDIY {



        private int[] heap;
        private int size;
        private int capacity;

        public PQDIY(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity];
            this.size = 0;
        }

        private int getParentIndex(int i) {
            return (i - 1) / 2;
        }

        private int getLeftChildIndex(int i) {
            return 2 * i + 1;
        }

        private int getRightChildIndex(int i) {
            return 2 * i + 2;
        }

        private boolean hasParent(int i) {
            return getParentIndex(i) >= 0;
        }

        private boolean hasLeftChild(int i) {
            return getLeftChildIndex(i) < size;
        }

        private boolean hasRightChild(int i) {
            return getRightChildIndex(i) < size;
        }

        private int parent(int i) {
            return heap[getParentIndex(i)];
        }

        private int leftChild(int i) {
            return heap[getLeftChildIndex(i)];
        }

        private int rightChild(int i) {
            return heap[getRightChildIndex(i)];
        }

        private void swap(int i1, int i2) {
            int temp = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = temp;
        }

        private void ensureExtraCapacity() {
            if (size == capacity) {
                heap = Arrays.copyOf(heap, capacity * 2);
                capacity *= 2;
            }
        }

        public void add(int value) {
            ensureExtraCapacity();
            heap[size] = value;
            size++;
            heapifyUp();
        }

        public int poll() {
            if (size == 0) throw new IllegalStateException("Queue is empty");
            int item = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown();
            return item;
        }

        public int peek() {
            if (size == 0) throw new IllegalStateException("Queue is empty");
            return heap[0];
        }

        private void heapifyUp() {
            int index = size - 1;
            while (hasParent(index) && parent(index) > heap[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        private void heapifyDown() {
            int index = 0;
            while (hasLeftChild(index)) {
                int smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }

                if (heap[index] < heap[smallerChildIndex]) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }






