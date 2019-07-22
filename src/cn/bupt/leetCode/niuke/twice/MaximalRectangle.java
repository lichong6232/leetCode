package cn.bupt.leetCode.niuke.twice;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:08 2019/6/2
 */
public class MaximalRectangle {

    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int rowNum = matrix.length;
        if (rowNum == 0){
            return 0;
        }
        int colNum = matrix[0].length;
        int height[] = new int[colNum];
        int max = 0;
        for (int k = rowNum-1;k>=0;k--){
            outer:
            for (int j=0;j<colNum;j++){
                height[j]=0;
                for (int i=k;i>=0;i--){
                    if (matrix[i][j]=='1'){
                        height[j]++;
                    }else {
                        continue outer;
                    }
                }
            }
            max = Math.max(max,getMaxRectangle(height));
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char matrix[][] = new char[][]{{'0','1','1','0','1'},
                {'1','1','0','1','0'},
                {'0','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'0','0','0','0','0'}};

        int i = maximalRectangle.maximalRectangle(matrix);
        System.out.println(i);
//        int maxRectangle = maximalRectangle.getMaxRectangle(new int[]{1});
//        System.out.println(maxRectangle);
    }

    private int getMaxRectangle(int height[]){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0;i<height.length;i++){
            while (!stack.isEmpty() && height[stack.peek()]>height[i]){
                int h = height[stack.pop()];
                max = Math.max(max,h*(i-1-(stack.isEmpty()?-1:stack.peek())));
            }
            stack.add(i);
        }
        while (!stack.isEmpty()){
            int h = height[stack.pop()];
            max = Math.max(max,h*(height.length-1-(stack.isEmpty()?-1:stack.peek())));
        }
        return max;
    }
}
