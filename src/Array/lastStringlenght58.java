package Array;

public class lastStringlenght58 {
    //返回含有空格的字符串的最后一个完整单词的长度，如果最后一个地方是空串，就要吧这个空去除再看
    public int lengthOfLastWord(String s) {
        // Trim any leading and trailing whitespace
        s = s.trim();

        int length = 0;
        int n = s.length();

        // Iterate from the end of the trimmed string
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break; // End of the last word
            }
            length++;
        }

        return length;
    }
}
