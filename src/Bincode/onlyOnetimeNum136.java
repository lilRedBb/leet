package Bincode;

public class onlyOnetimeNum136 {
    //数组中只出现过一次的一个数，找到
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num; // XOR operation
        }
        return single;
    }
    /**
     a ^ a = 0 (any number XORed with itself is 0)
     a ^ 0 = a (any number XORed with 0 is the number itself)
     XOR is commutative and associative.**/

    /**
     * a ^ b ^ c ^ a ^ b
     Using the commutative and associative properties of XOR, we can rearrange this expression:

     (a ^ a) ^ (b ^ b) ^ c
     Since a ^ a = 0 and b ^ b = 0, this simplifies to:

     0 ^ 0 ^ c
     Which is just:

     c**/
}
