package neetcode.medium.min_stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/min-stack/

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    private final List<Integer> arr;
    private final List<Integer> queue;

    public MinStack() {
        this.arr = new ArrayList<>();
        this.queue = new LinkedList<>();
    }

    public void push(int val) {
        this.arr.add(val);
        if (queue.isEmpty() || queue.getLast() >= val)
            queue.addLast(val);
    }

    public void pop() {
        if (!queue.isEmpty() && queue.getLast().equals(arr.getLast()))
            queue.removeLast();
        this.arr.removeLast();
    }

    public int top() {
        return this.arr.getLast();
    }

    public int getMin() {
        return queue.getLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
