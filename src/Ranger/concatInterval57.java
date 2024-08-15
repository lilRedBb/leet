package Ranger;

import java.util.ArrayList;
import java.util.List;

public class concatInterval57 {
    /**示例 1：

     输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     输出：[[1,5],[6,9]]
     示例 2：

     输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     输出：[[1,2],[3,10],[12,16]]

     把new放入old里面，如果new跨越了好几个old的子集，那么就把子集门连起来

     **/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add all intervals before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all intervals after newInterval
        while (i < intervals.length) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }



}
