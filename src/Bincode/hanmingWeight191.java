package Bincode;

public class hanmingWeight191 {
    /**输入：n = 11
     输出：3
     解释：输入的二进制串 1011 中，共有 3 个设置位。**/
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1; // Unsigned right shift
        }
        return count;
    }

    /**This solution works by iterating through each bit of the integer n.
     * It uses the bitwise AND operator (&) to check if the least significant bit is 1,
     * then increments the count if it is. It uses the unsigned right shift operator (>>>) to shift the bits of
     * n to the right, filling with zeros from the left. This process continues until all bits have been processed.**/
}
