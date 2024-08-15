package Mathmath;

public class palidrome9 {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        // Numbers that end in 0 are not palindrome unless the number is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
