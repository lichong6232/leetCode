package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:32 2019/4/23
 */
public class GenerateParentheses {

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        generate(0,0,n,"",result);
        return result;

    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        ArrayList<String> list = generateParentheses.generateParenthesis(3);
        System.out.println(list);
    }

    private void generate(int left, int right, int n, String s, ArrayList<String> result){
        if (left == n && right == n){
            result.add(s);
            return;
        }
        if (left<n){
            generate(left+1,right,n,s+"(",result);
        }
        if (left>right){
            generate(left,right+1,n,s+")",result);
        }
    }



}
