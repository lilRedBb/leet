package Ranger;

import java.util.ArrayList;
import java.util.List;

public class SummeryRange228 {
    /**输入：nums = [0,1,2,4,5,7]
     输出：["0->2","4->5","7"]**/
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                addRange(result, start, end);
                start = nums[i];
                end = nums[i];
            }
        }

        // Add the last range
        addRange(result, start, end);

        return result;
    }
    private void addRange(List<String> result, int start, int end) {
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
    }
}
