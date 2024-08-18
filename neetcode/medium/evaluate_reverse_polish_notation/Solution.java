package neetcode.medium.evaluate_reverse_polish_notation;

import java.util.Stack;

/*
https://leetcode.com/problems/evaluate-reverse-polish-notation/

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class Solution {
    public static int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();

        for (var token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int secondValue = stack.pop();
                    int firstValue = stack.pop();
                    stack.push(firstValue - secondValue);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int secondValue = stack.pop();
                    int firstValue = stack.pop();
                    stack.push(firstValue / secondValue);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] {"2","1","+","3","*"}));
    }
}
