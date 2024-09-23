package DP;

public class longestAcendQuick300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            // Binary search to find the insertion point of num in tails
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Update the tails array
            tails[left] = num;
            if (left == size) {
                size++;  // Extend the size of the array if a new element is added at the end
            }
        }

        return size;  // The size represents the length of the longest increasing subsequence
    }
    /**Replace vs. Extend:
     Extend (left = mid + 1):

     If num is larger than all current elements in tails[], binary search will eventually move left to the position just beyond the current tails[] array.
     This means num should be added to the end of tails[], extending the length of the subsequence.
     Replace (right = mid):

     If num is smaller or equal to tails[mid], we consider num a candidate to replace tails[mid] (or some element to the left of it).
     This is done by setting right = mid, narrowing the search range to the left half, and finding the smallest position where num can fit.**/
}
