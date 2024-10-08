package Bincode;

public class BinCalculate67 {
    /**输入:a = "11", b = "1"
     输出："100"**/
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) result.append(carry);

        return result.reverse().toString();
    }
}
