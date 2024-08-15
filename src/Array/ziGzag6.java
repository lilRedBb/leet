package Array;

public class ziGzag6 {

    /**将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

     比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

     P   A   H   N
     A P L S I I G
     Y   I   R

     输入：s = "PAYPALISHIRING", numRows = 4
     输出："PINALSIGYAHRPI"
     解释：
     P     I    N
     A   L S  I G
     Y A   H R
     P     I

     **/
    public String convert(String s, int numRows) {
        // Base condition checks
        if (s == null || s.length() == 0 || numRows <= 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }

        // Resultant string
        StringBuilder result = new StringBuilder();

        // Step size
        int step = 2 * numRows - 2;

        // Loop through each row
        //每一次，第一个j就已经放进去了，之后if的计算是之后的j
        for (int i = 0; i < numRows; i++) {
            // Loop through each character in the row
            for (int j = i; j < s.length(); j += step) {
                result.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && (j + step - 2 * i) < s.length()) {
                    int oo = j + step - 2 * i;
                    result.append(s.charAt(j + step - 2 * i));
                }
            }
        }

        return result.toString();



    }


    /**Base Conditions:

     If the string is null, empty, or the number of rows is less than or equal to zero, return an empty string.
     If the number of rows is one, return the original string as no conversion is needed.
     Step Size Calculation:

     The step size is calculated as 2 * numRows - 2.
     Loop Through Rows:

     For each row, loop through the string, jumping by the step size.
     Append characters at the current position.
     For middle rows (not the first or last), append the characters at positions calculated by j + step - 2 * i.**/


}
