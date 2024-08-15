package BinSearch;

public class peakElement162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // The peak is in the left half
                right = mid;
            } else {
                // The peak is in the right half
                left = mid + 1;
            }
        }

        // Left will point to the peak element
        return left;
    }
}
