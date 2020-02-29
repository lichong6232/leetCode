package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:36 2019/9/13
 */
public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        int ans[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<2*nums.length;i++){
            if (i<nums.length){
                ans[i] = -1;
            }
            int temp = nums[i%nums.length];
            while (!stack.isEmpty() && nums[stack.peek()]<temp){
                ans[stack.pop()] = temp;
            }
            stack.add(i%nums.length);

        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElement2 nextGreaterElement2 = new NextGreaterElement2();
        int nums[] = new int[]{1,2,3,2,1};
        int[] ints = nextGreaterElement2.nextGreaterElements(nums);
        System.out.println(Arrays.toString(ints));
    }
}
