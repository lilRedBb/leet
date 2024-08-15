package BinSearch;

public class flipedArray33 {
    //sorted
    //[1,2,3,4,5] 变成了 [34512], 这种反转的情况下二分法要加入更多的条件
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which part is sorted
            if (nums[left] <= nums[mid]) { // Left part is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is in the left sorted part
                    right = mid - 1;
                } else {
                    // Target is in the right part
                    left = mid + 1;
                }
            } else { // Right part is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target is in the right sorted part
                    left = mid + 1;
                } else {
                    // Target is in the left part
                    right = mid - 1;
                }
            }
        }

        return -1; // Target is not found
    }
}
