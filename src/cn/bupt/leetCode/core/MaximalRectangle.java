package cn.bupt.leetCode.core;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:30 2019/9/14
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int height[][] = new int[row + 1][col];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    height[i + 1][j] = height[i][j] + 1;
                } else {
                    height[i + 1][j] = 0;
                }
            }
        }
        int maxRectangle = 0;
        for (int i = 0; i < row; i++) {
            maxRectangle = Math.max(maxRectangle,largestRectangleArea(height[i+1]));
        }
        return maxRectangle;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i=0;i<heights.length;i++){
            while (!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int height = heights[stack.pop()];
                max = Math.max(max,height*(i-(stack.isEmpty()?-1:stack.peek())-1));
            }
            stack.add(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            int height = heights[index];
            int length = stack.isEmpty()?heights.length:heights.length-stack.peek()-1;
            max = Math.max(max,height*length);
        }
        return max;
    }

    public static void main(String[] args) {
        char matrix[][] = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        int i = maximalRectangle.maximalRectangle(matrix);
        System.out.println(i);
    }

}
