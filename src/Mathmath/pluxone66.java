package Mathmath;

public class pluxone66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, just add one and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Otherwise, set the current digit to 0 and continue to the next iteration
            digits[i] = 0;
        }

        // If we are here, it means all digits were 9
        // We need an array with an extra digit
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1; // The rest of the array is already initialized to 0

        return newNumber;
    }
}
