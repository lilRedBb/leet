package BinSearch;

public class sortedArrayfindtwo34 {
    //在排序数组中找到同一个target值的第一次出现的下标和最后一个下标
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // Check if this is the first occurrence
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid; // This is the first occurrence
                }
                right = mid - 1; // Move left to find the first occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }


    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // Check if this is the last occurrence
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid; // This is the last occurrence
                }
                left = mid + 1; // Move right to find the last occurrence
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

}
