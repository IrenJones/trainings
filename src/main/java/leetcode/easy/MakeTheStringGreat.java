package leetcode.easy;

import java.util.Stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(cur);
            } else{
                Character prev = stack.peek();
                if(Character.toLowerCase(prev) == Character.toLowerCase(cur)){
                    if(Character.isUpperCase(prev) && Character.isLowerCase(cur) || Character.isUpperCase(cur) && Character.isLowerCase(prev)){
                        stack.pop();
                    } else{
                        stack.push(cur);
                    }
                } else{
                    stack.push(cur);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
