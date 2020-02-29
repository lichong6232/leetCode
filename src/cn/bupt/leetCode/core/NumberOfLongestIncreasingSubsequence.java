package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:37 2019/9/25
 */
public class NumberOfLongestIncreasingSubsequence {

    //https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/tao-lu-jie-jue-zui-chang-zi-xu-lie-deng-yi-lei-wen/

    public int findNumberOfLIS(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int length[] = new int[nums.length];
        int count[] = new int[nums.length];
        Arrays.fill(length,1);
        Arrays.fill(count,1);
        int longest = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    if (length[j]>=length[i]){
                        length[i] = length[j]+1;
                        count[i] = count[j];
                    }else if (length[i] == length[j]+1){
                        count[i]+=count[j];
                    }
                }
            }
            longest = Math.max(length[i],longest);
        }
        System.out.println(longest);
        int ans = 0;
        for (int i=0;i<length.length;i++){
            if (length[i] == longest){
                ans+=count[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,5,4,7};
        NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();
        int numberOfLIS = numberOfLongestIncreasingSubsequence.findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
        //1,2,4,5,7
        //1,2,3,5,7
        //1,2,3,4,7
    }
}
