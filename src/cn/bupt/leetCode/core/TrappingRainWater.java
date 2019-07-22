package cn.bupt.leetCode.core;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:49 2019/7/20
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i=0;i<height.length;i++){
            while (!stack.isEmpty() && height[stack.peek()]<=height[i]){
                Integer pop = stack.pop();
                if (!stack.isEmpty()){
                    int leftIndex = stack.peek();
                    max+=(Math.min(height[leftIndex],height[i])-height[pop])*(i-leftIndex-1);
                }

            }
            stack.add(i);
        }
        return max;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int height[] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trappingRainWater.trap(height);
        System.out.println(trap);
    }
}
