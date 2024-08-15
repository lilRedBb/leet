package doublePointer;

public class twoSumINarray167 {
    //在列表里找到两个数，和等于target，两个数不能是一样 的，
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // The indices are 1-based, so we return left + 1 and right + 1
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++; // Move the left pointer to the right to increase the sum
            } else {
                right--; // Move the right pointer to the left to decrease the sum
            }
        }

        // If no solution is found, though the problem guarantees one exists, we return an empty array
        return new int[] {};
    }
}
