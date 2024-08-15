package Array;

public class mostElement169 {
    //moore counting
    //这里计算的不是出现次数最多的，而是出现频率大于1/2的，所以这样做是对的，不然还是要计算max
    public int majorityElement(int[] nums) {
        int count=0;
        Integer candidate = null;
        for (int num:nums){
            if (count==0){
                candidate = num;

            }
            count += (candidate==num)?1:-1;
        }
        return candidate;
    }
}
