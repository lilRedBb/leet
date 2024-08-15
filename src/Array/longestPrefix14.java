package Array;

public class longestPrefix14 {
    //substring(0,length)， 就是去除最后一个字符的意思，不断的去除最后一个字符，直到相同，或者str变成empty
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        //index of 用法f the prefix is found in the string,
        // the indexOf method will return the index of the first character of the prefix within the string.
        //所以这里写的是0，因为匹配好的字段的第一位就是0
        //匹配失败，indexof返回-1

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
