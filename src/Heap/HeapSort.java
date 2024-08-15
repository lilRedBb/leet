package Heap;

public class HeapSort {

    public void heapSort(int[] arr) {
        int n = arr.length;


        /**Why Start at n/2 - 1?:

         The nodes from index n/2 to n-1 are leaf nodes, and they don’t need to be
         heapified because they already satisfy the heap property by default (a leaf node has no children to violate the heap property).
         Therefore, to build the heap, you only need to heapify non-leaf nodes, which are located from index n/2 - 1 down to 0.
         Starting from n/2 - 1 ensures that you heapify the last non-leaf node first, and then work your way upwards to the root of the tree (index 0).**/

        // Step 1: Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        //前半段是非leaf的点，只要对前半段进行heapify，后半段也会被影响，英文后面是前面的left right

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end (swap arr[0] with arr[i])
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify a subtree rooted with node i, which is an index in arr[].
    // n is the size of the heap (or the size of the part of the array being heapified)
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Utility function to print the array
    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main function to test the code
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Unsorted array:");
        sorter.printArray(arr);

        sorter.heapSort(arr);

        System.out.println("Sorted array:");
        sorter.printArray(arr);
    }
}
/**Step 1: Build a Max Heap
 Heapify the Array: First, you convert the array into a max heap.
 As we discussed earlier, you do this by starting from the first non-leaf node and moving upward to the root, calling the heapify function on each node.
 Step 2: Swap the Root with the Last Element
 Swap the Root: Once the array is a max heap, the largest element is at the root (the first element of the array).
 Move the Largest Element: You then swap this root element with the last element of the heap (i.e., the last element of the unsorted portion of the array).
 This step effectively "removes" the largest element from the heap, placing it at the end of the array where it belongs in sorted order.
 Step 3: Heapify the Remaining Heap
 Restore the Heap Property: After swapping, the heap property might be violated at the root
 (because the new root is the element that was at the end of the array). So, you need to restore the max heap by calling
 the heapify function on the root node, considering only the remaining unsorted portion of the array (i.e., reduce the effective heap size by 1).
 Step 4: Repeat
 Continue the Process: Repeat the swap and heapify process until the entire array is sorted.**/

