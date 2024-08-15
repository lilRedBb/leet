package stack;

import java.util.Stack;

public class simplifyPaht71 {
    /**示例 3：

     输入：path = "/home//foo/"
     输出："/home/foo"
     解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     示例 4：

     输入：path = "/a/./b/../../c/"
     输出："/c"**/
    public String simplifyPath(String path) {
        // Split the path by "/"
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();

        // Iterate over each directory in the split path
        for (String dir : dirs) {
            if (dir.isEmpty() || dir.equals(".")) {
                // Skip empty and current directory elements
                continue;
            } else if (dir.equals("..")) {
                // Pop from stack if the current element is ".." and stack is not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Push the current directory onto the stack
                stack.push(dir);
            }
        }

        // Join the stack elements to form the simplified path，新出来的STRING会用/来分隔文件命名
        return "/" + String.join("/", stack);
    }
}
