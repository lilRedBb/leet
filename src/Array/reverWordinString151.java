package Array;

public class reverWordinString151 {

    //就是string变成列表reverse
    public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }

            // Split the string by spaces
            String[] words = s.trim().split("\\s+");

            // Use StringBuilder to build the reversed string
            StringBuilder sb = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {
                sb.append(words[i]);
                if (i != 0) {
                    sb.append(" ");
                }
            }

            return sb.toString();
        }

     //方法2不占用多余的空间，但是判断多
     public String reverseWords2(String s) {
         if (s == null || s.length() == 0) {
             return "";
         }

         // Trim leading and trailing spaces
         s = s.trim();

         // Use StringBuilder to build the reversed string
         StringBuilder sb = new StringBuilder();
         int end = s.length();

         for (int i = s.length() - 1; i >= 0; i--) {
             if (s.charAt(i) == ' ') {
                 if (end != i + 1) {
                     sb.append(s.substring(i + 1, end)).append(' ');
                 }
                 end = i;
             } else if (i == 0) {
                 sb.append(s.substring(i, end)).append(' ');
             }
         }

         // Remove the trailing space and return the result
         return sb.toString().trim();
     }

     /**Inner if Condition (end != i + 1):
      * 要除去可能存在的连续的space，所以特特别麻烦
      * 就是把两个space之间的单个字符更新到表里，如果存在连续space就直接让end--，来略过多出来的space

      This ensures that the space is not consecutive or redundant.
      end != i + 1 means that there is at least one non-space character between the current and previous space.
      Appending Substring (sb.append(s.substring(i + 1, end)).append(' ')):

      This appends the word found between the indices i + 1 and end to the StringBuilder, followed by a space.
      s.substring(i + 1, end) extracts the substring from index i + 1 to end (exclusive), which is the word between spaces.**/


}
