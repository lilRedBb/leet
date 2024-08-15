package doublePointer;

public class paliDrome125 {
    //回文，正反顺序都是一样的文字，忽略标点和大小写
    //中间两个while的意思是，在外围大loop每次对比两个char之前，要看一看目前的char是不是标点符号，如果是，就跳过标点符号
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move both pointers towards the center
            left++;
            right--;
        }

        return true;
    }
}
