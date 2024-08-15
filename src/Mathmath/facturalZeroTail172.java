package Mathmath;

public class facturalZeroTail172 {
    public int trailingZeroes(int n) {
        int count = 0;
        // Count the number of times 5 is a factor
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
    /**No, you cannot use 2 instead of 5 to count trailing zeroes in factorials, and here's why:

     Key Difference:
     Trailing Zeroes: A trailing zero in a number is produced by a factor of 10. Since
     10
     =
     2
     ×
     5
     10=2×5, every trailing zero requires both a factor of 2 and a factor of 5.
     Abundance of 2s: In any factorial
     𝑛
     !
     n!, there are always more factors of 2 than factors of 5 because every second number is even (providing a factor of 2).
     Scarcity of 5s: Factors of 5 are less frequent (only every fifth number).
     Why 5 is Essential:
     Since the number of trailing zeroes is determined by the number of pairs of factors (2 and 5) that multiply to form 10, and since factors of 2 are more abundant, the limiting factor is the number of factors of 5. This is why we count the factors of 5 and not 2.**/
}
