package leetcode.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s: tokens){
            switch(s){
                case("+"):{
                    stack.push(stack.pop() + stack.pop());
                    break;
                }
                case("-"):{
                    stack.push( - stack.pop() + stack.pop());
                    break;
                }
                case("*"):{
                    stack.push(stack.pop() * stack.pop());
                    break;
                }
                case("/"):{
                    int v1 = stack.pop();
                    int v2 = stack.pop();
                    stack.push(v2 / v1);
                    break;
                }
                default:{
                    stack.push(Integer.valueOf(s));
                }
            }
        }

        return stack.pop();
    }
}
