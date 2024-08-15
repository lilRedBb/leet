package Heap;

import java.util.Random;

public class kBigestByQuicks215 {
    //这是quick select sort
    //先用随机数把array分成两边，小的左边，大的右边，如果k大于随机数的index，就说明kth元素在右边， 不然就是在左边
    //这样，为了找到kth，我们只需要sort左右中的一边就可以了



        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left == right) {
                return nums[left]; // If the list contains only one element
            }

            Random random = new Random();
            int pivotIndex = left + random.nextInt(right - left + 1);

            pivotIndex = partition(nums, left, right, pivotIndex);

            if (k == pivotIndex) {
                return nums[k]; // The pivot is in its final sorted position
            } else if (k < pivotIndex) {
                return quickSelect(nums, left, pivotIndex - 1, k);
            } else {
                return quickSelect(nums, pivotIndex + 1, right, k);
            }
        }

        private int partition(int[] nums, int left, int right, int pivotIndex) {
            int pivot = nums[pivotIndex];
            // Move pivot to end
            swap(nums, pivotIndex, right);
            int storeIndex = left;

            // Move all smaller elements to the left
            for (int i = left; i < right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, storeIndex, i);
                    storeIndex++;
                }
            }

            // Move pivot to its final place
            swap(nums, right, storeIndex);
            return storeIndex;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


}
