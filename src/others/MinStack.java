package others;

import java.util.*;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * Created by Zlatan on 19/3/11.
 */
class MinStack {

    private Stack<Integer> minStack;

    private Stack<Integer> normalStack;

    /** initialize your data structure here. */
    public MinStack() {
        this.minStack = new Stack<>();
        this.normalStack = new Stack<>();
    }

    public synchronized void push(int x) {
        normalStack.push(x);
        if (minStack.isEmpty() || minStack.peek() > x) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public synchronized void pop() {
        normalStack.pop();
        minStack.pop();
    }

    public synchronized int top() {
        return normalStack.peek();
    }

    public synchronized int getMin() {
        return minStack.peek();
    }
}
