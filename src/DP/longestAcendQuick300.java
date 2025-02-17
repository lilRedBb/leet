package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//300题是不需要连续的sub，所以可以用最下面的nlogn方法，但是674需要连续的sub。

public class longestAcendQuick300 {

    //先走列表，同时用二分查找在新表中看有没有原表中的元素，有就对位修改一下（没影响），找不到就返回这个数可以放在哪，然后替换lis原来的数
    //这一题的关键不在于最后lis里的数的顺序是否正确，其实只要执行了这个逻辑，lis最后的长度，一定就是最长的可能性，但是里面数的顺序应该是错误的
    //比如第一位是2， 后面出现了1， 1把2替换掉了，那么Lis的顺序就没有按照数字出现的顺序来排
    //但是，这个时候，lis的长度还是正确答案，而且把第一位换成1，后面有新的数加进来，也会从1后面修改，慢慢的就有可能增加lis长度
    //就算没郑家lis长度，答案也是正确的


    //collections.binsearch的返回
    //找得到就是 找到的数字所在的坐标
    //If num is smaller than all elements, the return value is -1 (insert at index 0).
    //If num is larger than all elements, the return value is -(size+1).
    //If num should be inserted at index i, the return value is -(i + 1).
    //贪心+二分， 时间复杂度nlogn
    public int lengthOfLISOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1); // Convert to insert position
            if (pos >= lis.size()) lis.add(num);
            else lis.set(pos, num); // Replace element at pos
        }

        return lis.size();
    }

}
