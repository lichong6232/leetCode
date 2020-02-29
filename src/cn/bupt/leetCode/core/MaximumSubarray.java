package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:40 2019/8/5
 */
public class MaximumSubarray {

    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

     Example:

     Input: [-2,1,-3,4,-1,2,1,-5,4],
     Output: 6
     Explanation: [4,-1,2,1] has the largest sum = 6.
     Follow up:

     If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int max = nums[0];
        int sum =0;
        for (int i=0;i<nums.length;i++){
            int num = nums[i];
            sum +=num;
            max = Math.max(max,sum);
            if (sum<0){
                sum = 0;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int nums[]= new int[]{1,2};
        int max = maximumSubarray.maxSubArray(nums);
        System.out.println(max);
    }

}
