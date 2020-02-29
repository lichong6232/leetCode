package cn.bupt.leetCode.core;

import javax.swing.plaf.nimbus.State;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:43 2019/9/16
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums.length<1){
            return 0;
        }
        int left=Integer.MAX_VALUE,right = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                left = Math.min(left,stack.pop());
            }
            stack.add(i);
        }
        System.out.println(left);
        stack.clear();
        for (int i = nums.length-1;i>=0;i--){
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                right = Math.max(right,stack.pop());
            }
            stack.add(i);
        }
        System.out.println(right);
        return left>right?0:right-left+1;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2,6,4,8,10,9,15};
        ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = new ShortestUnsortedContinuousSubarray();
        int unsortedSubarray = shortestUnsortedContinuousSubarray.findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }
}
