package cn.bupt.leetCode.niuke;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:09 2019/4/16
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int max = 0,pos = -1;
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == '('){
                stack.add(i);
            }else {
                if (stack.isEmpty()){
                    pos = i;
                }else {
                    stack.pop();
                    if (!stack.isEmpty()){
                        max = Math.max(max,i-stack.peek());
                    }else {
                        max = Math.max(max,i-pos);
                    }
                }

            }
        }
        return max;

    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String s = "()(()(())";
//        s="(()))";
//        s=")()())";
        int i = longestValidParentheses.longestValidParentheses(s);
        System.out.println(i);
    }
}
