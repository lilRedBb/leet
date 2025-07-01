package Ranger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeInterval56 {
    /**输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     输出：[[1,6],[8,10],[15,18]]**/
    public int[][] merge(int[][] intervals) {
        // Sort the intervals by their start times
        //比较ab两个数的大小来排序，ab是什么，a是a【0】， b是b[0]
        //Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged list is empty or no overlap, add the interval to the merged list
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // If there is an overlap, merge the intervals
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
        //the return type is int[][], but merged is List<int[]>, so we have to convert
        //java在构造  int  string [][] 的时候必须要加上size的，可以是0，也可以是转化过来的collection的size
    }
}
