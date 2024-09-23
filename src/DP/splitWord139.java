package DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class splitWord139 {
    /**
     * s = "leetcode", wordDict = ["leet", "code"]
     输出: true
     解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成
     输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     输出: false

     **/
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // Convert list to set for O(1) lookup
        boolean[] dp = new boolean[s.length() + 1];  // dp[i] is true if s[0..i-1] can be segmented
        dp[0] = true;  // Base case: empty string can be segmented

        //检查到一个单词以后，就立刻跳出，并且标记这个单词的末位为true，方便后面的单词判断
        //后面单词的true需要本身匹配wordset+前面单词末位+1为true，

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    //set 和 hashtable 的 contains方法都需要  寻找的东西完全= 自身的元素才会返回ture, 如果外界的string只是自身的subset，返回false
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
    /**Let's walk through how the dp array
     * would look like for the string s = "hello" and the wordSet = {"hell", "o"} using the wordBreak method.
     dp array: [true, false, false, false, true, true]
     *
     * **/
}
