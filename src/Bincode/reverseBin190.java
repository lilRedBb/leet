package Bincode;

public class reverseBin190 {
    /**Iteration 4:
     Left shift result:
     result <<= 1 -> result = 00000000000000000000000000001100
     Add least significant bit of n to result:
     result |= (n & 1) -> result = 00000000000000000000000000001100 (since n & 1 is 0)
     Right shift n:
     n >>= 1 -> n = 00000000000000000000000000000000
     ... and so on, until Iteration 32.

     Final Result
     After 32 iterations, the result will have all the bits of n reversed. For n = 3, which is 00000000000000000000000000000011 in binary, the reversed bits would be 11000000000000000000000000000000.

     To convert the binary back to decimal:

     11000000000000000000000000000000 (binary) = 3221225472 (decimal)**/
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;     // Left shift result by 1 to make space for the next bit
            result |= (n & 1); // Add the least significant bit of n to result
            n >>= 1;          // Right shift n by 1 to process the next bit
        }
        return result;
    }
}
