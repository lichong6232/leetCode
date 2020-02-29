package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:16 2019/9/25
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int start =0;
        int max = 0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]>=nums[i+1]){
                max = Math.max(max,i-start+1);
                start=i+1;
            }
        }
        max = Math.max(max,nums.length-start);
        return max;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = new LongestContinuousIncreasingSubsequence();
        int nums[] = new int[]{1,3,5,6,7};
        int lengthOfLCIS = longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }
}
