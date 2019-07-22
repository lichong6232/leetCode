package cn.bupt.leetCode.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:18 2019/6/24
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for (Character c : s.toCharArray()){
            if (map.containsKey(c) || stack.isEmpty()){
                stack.add(c);
            }else {
                Character pop = stack.pop();
                if (!c.equals(map.get(pop))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("()");
        System.out.println(valid);
    }
}
