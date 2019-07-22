package cn.bupt.leetCode.core;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:21 2019/6/23
 */
public class ContainerWithMostWater {

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

     Note: You may not slant the container and n is at least 2.
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i=0;i<height.length;i++){
            while (!stack.isEmpty() && height[stack.peek()]<height[i]){
                int index = stack.pop();
                max = Math.max(max,height[index]*(stack.isEmpty()?0:index-stack.peek()));
            }
            stack.add(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            max = Math.max(height[index]*(stack.isEmpty()?0:index-stack.peek()),max);
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int array[] = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = containerWithMostWater.maxArea(array);
        System.out.println(maxArea);
    }
}
