package cn.bupt.leetCode.niuke.twice;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:24 2019/5/1
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int operator2 = stack.pop();
                int operator1 = stack.pop();
                int result = 0;
                switch (token){
                    case "+" :
                        result = operator1+operator2;
                        break;
                    case "-":
                        result = operator1-operator2;
                        break;
                    case "*":
                        result = operator1*operator2;
                        break;
                    default:
                        result = operator1/operator2;

                }
                stack.add(result);
            }else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        String tokens[] = new String[]{"4","13","5","/","+"};
        int i = evaluateReversePolishNotation.evalRPN(tokens);
        System.out.println(i);

    }


}
