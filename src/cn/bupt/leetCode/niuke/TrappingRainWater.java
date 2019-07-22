package cn.bupt.leetCode.niuke;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:19 2019/4/7
 */
public class TrappingRainWater {

    public int trap(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0;i<A.length;i++){
            while (!stack.isEmpty() && A[i]>A[stack.peek()]){
                Integer rightIndex = i;
                int nowHeight = A[stack.pop()];
                if (!stack.isEmpty()){
                    Integer leftIndex = stack.peek();
                    int minHeight = Math.min(A[leftIndex],A[rightIndex]);
                    result += (rightIndex-leftIndex-1)*(minHeight-nowHeight);
                }
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int A[] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trappingRainWater.trap(A);
        System.out.println(trap);
    }
}
