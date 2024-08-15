package Bincode;

public class onlyOnetimeII137 {
    //一个数出现了1次，其他是3次
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            // Update ones and twos
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
    /**ones = (ones ^ num) & ~twos: This line updates ones to include bits that have
      appeared once but not twice. The & ~twos part ensures that if a bit has appeared three times,
     it will be reset in ones.
     twos = (twos ^ num) & ~ones: Similarly, this line updates twos to include bits that have appeared
     twice but not once.
     The & ~ones part ensures that if a bit has appeared three times, it will be reset in twos.
     加入13连续出现三次
     第一次one会变成13，two 0
     第二次 0   13
     第三次 0    0

     **/

}
