package cn.bupt.leetCode.core;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:16 2019/10/25
 */
public class RemoveKDigitsMax {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        for (char c : chars){
            while (k>0 && !stack.isEmpty() && c>stack.peek()){
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && c == '0'){
                continue;
            }
            stack.push(c);
        }
        int size = stack.size();
        int remain = size - k;
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty() && remain>0){
            stringBuilder.insert(0,stack.pop());
        }
        return stringBuilder.length()==0?"0":stringBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveKDigitsMax removeKDigitsMax = new RemoveKDigitsMax();
        String num = "123456";
        String s = removeKDigitsMax.removeKdigits(num, 2);
        System.out.println(s);
    }
}
