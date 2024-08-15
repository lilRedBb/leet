package BinSearch;

public class flipedArrayMIn153 {
    //在不断被反转后的列表中找到最小值
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the rightmost element,
            // the minimum must be in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the minimum is in the left half (including mid)
                right = mid;
            }
        }

        // After the loop, left == right and it points to the minimum element
        return nums[left];
    }
}
