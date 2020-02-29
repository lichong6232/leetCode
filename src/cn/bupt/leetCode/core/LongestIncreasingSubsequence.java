package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:30 2019/9/25
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        int max =0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i] && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int nums[] = new int[]{10,9,2,5,3,7,101,18};
        int i = longestIncreasingSubsequence.lengthOfLIS(nums);
        System.out.println(i);
    }
}
