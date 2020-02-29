package cn.bupt.leetCode.core;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:01 2019/10/24
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        for (char c:chars){
            while (k>0 && !stack.isEmpty() && c<stack.peek()){
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && c=='0'){
                continue;
            }
            stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        while (k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()){
            result.insert(0,stack.pop());
        }
        return result.length() == 0?"0":result.toString();

    }

    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        String num = "1432219";
        String s = removeKDigits.removeKdigits(num, 3);
        System.out.println(s);
    }
}
