package stack;

import java.util.Stack;

public class minStack155 {
    //创建一个类，可以返回stack里面的最小值，时间复杂的为常熟
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public minStack155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
