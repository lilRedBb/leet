package Array;

import java.util.Arrays;

public class Hcitation274 {
    //给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
    //
    //根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
    // 并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。

    //先把列表排序，从小递增上去，如果列表的前面某个citation【i】大于h指数的话，那它后面的也都肯定大于这个指数，那么就返回这个指数
    //h在每一个Loop也要同时缩小1的原因是，如果保持不变，那么它就不符合前面的数的要求了，所以只要一不符合就立刻-1

    public int hIndex(int[] citations) {
        //n-i，就是
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }
    public int hIndexBucketSort(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];

        // Step 1: Count occurrences of each citation count
        for (int c : citations) {
            if (c >= n) {
                count[n]++; // Any citation ≥ n is counted in the last bucket
            } else {
                count[c]++;
            }
        }

        // Step 2: Accumulate counts from right to left
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i]; // Sum up countsx向后累加，
            //假如已经有大于n个引用数量>n的论文，那么你的答案就是n啊，
            //因为再往下走，n只会越来越小
            if (total >= i) {  // First time total >= index
                return i;
            }
        }

        return 0;
    }

}
