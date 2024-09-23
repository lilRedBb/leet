package BinSearch;

public class SearchInsertPosi35 {
    //找得到就返回索引，找不到就返回插入的下标
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // Position where target should be inserted
    }


    public int searchInsert2(int[] nums, int target) {
        return searchInsertHelper(nums, target, 0, nums.length - 1);
    }

    private int searchInsertHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left; // Position where target should be inserted
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchInsertHelper(nums, target, mid + 1, right);
        } else {
            return searchInsertHelper(nums, target, left, mid - 1);
        }
    }
}
