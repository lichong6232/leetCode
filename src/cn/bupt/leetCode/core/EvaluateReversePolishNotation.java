package cn.bupt.leetCode.core;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:31 2019/8/7
 */
public class EvaluateReversePolishNotation {

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

     Valid operators are +, -, *, /. Each operand may be an integer or another expression.

     Note:

     Division between two integers should truncate toward zero.
     The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
     Example 1:

     Input: ["2", "1", "+", "3", "*"]
     Output: 9
     Explanation: ((2 + 1) * 3) = 9
     Example 2:

     Input: ["4", "13", "5", "/", "+"]
     Output: 6
     Explanation: (4 + (13 / 5)) = 6
     Example 3:

     Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
     Output: 22
     Explanation:
     ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     = ((10 * (6 / (12 * -11))) + 17) + 5
     = ((10 * (6 / -132)) + 17) + 5
     = ((10 * 0) + 17) + 5
     = (0 + 17) + 5
     = 17 + 5
     = 22

     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)){
                Integer operator2 = stack.pop();
                Integer operator1 = stack.pop();
                switch (token){
                    case "+":
                        stack.add(operator1+operator2);
                        break;
                    case "-":
                        stack.add(operator1-operator2);
                        break;
                    case "*":
                        stack.add(operator1*operator2);
                        break;
                    default:
                        stack.add(operator1/operator2);
                }
            }else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String tokens[] = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result = evaluateReversePolishNotation.evalRPN(tokens);
        System.out.println(result);
    }
}
