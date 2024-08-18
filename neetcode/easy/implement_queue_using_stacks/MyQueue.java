package neetcode.easy.implement_queue_using_stacks;

import java.util.Stack;

/*
https://leetcode.com/problems/implement-queue-using-stacks/

Implement a first in first out (FIFO) queue using only two stacks.
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size,
and is empty operations are valid.
Depending on your language, the stack may not be supported natively.
You may simulate a stack using a list or deque (double-ended queue) as long as you use
only a stack's standard operations.
 */
class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> assistStack;

    public MyQueue() {
        stack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        move(stack, assistStack);
        assistStack.push(x);
        move(assistStack, stack);
    }

    private void move(Stack<Integer> source, Stack<Integer> target) {
        target.clear();

        while (!source.isEmpty())
            target.push(source.pop());
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
