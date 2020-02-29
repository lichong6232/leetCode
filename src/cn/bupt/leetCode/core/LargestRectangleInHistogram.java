package cn.bupt.leetCode.core;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:43 2019/9/14
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
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
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int height[] = new int[]{2,1,5,6,2,3};
        int i = largestRectangleInHistogram.largestRectangleArea(height);
        System.out.println(i);
    }
}
