package cn.bupt.leetCode.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:10 2019/4/26
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.add(')');
            }else if (c == '{'){
                stack.add('}');
            }else if (c == '['){
                stack.add(']');
            }else if (stack.isEmpty() || stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "{}()[][";
        boolean valid = validParentheses.isValid(s);
        System.out.println(valid);
    }
}
