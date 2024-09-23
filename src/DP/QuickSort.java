package DP;

public class QuickSort {

    // Method to perform QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is the partitioning index, arr[pi] is now at the correct place
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            //经过第一轮的partritipon，到这里的时候，pi前面的数一定比pi后面的都要小
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Method to partition the array
    //逻辑就是抽出最后一个元素当做标准，前面的元素一个一个过来比，比pivot小的元素会被放到列表的前面位置
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Pivot element (last element in array)
        int i = (low - 1);  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        //把最后位置的pivot放到比他小的元素的后面
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Main method to test the QuickSort implementation
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println("Unsorted array:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
