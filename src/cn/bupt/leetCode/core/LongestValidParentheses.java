package cn.bupt.leetCode.core;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:20 2019/7/14
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int max=0,pos = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '('){
                stack.add(i);
            }else {
                if (stack.isEmpty()){
                    pos = i;
                }else {
                    stack.pop();
                    if (stack.isEmpty()){
                        max = Math.max(max,i-pos);
                    }else {
                        max = Math.max(max,i-stack.peek());
                    }
                }
            }
        }
        return max;
    }

}
