package Bincode;

public class bitAndALLrange201 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // Find the common prefix
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        // Shift back to the left
        return m << shift;
    }
}
