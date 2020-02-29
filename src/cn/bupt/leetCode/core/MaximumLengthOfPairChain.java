package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:50 2019/9/26
 */
public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int n = pairs.length;
        int dp[] = new int[n];
        int max = 0;
        for (int i=0;i<n;i++){
            dp[i] = 1;
            for (int j=0;j<i;j++){
                if (pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumLengthOfPairChain maximumLengthOfPairChain = new MaximumLengthOfPairChain();
        //[-5,2] [-5,8] [-3,7] [-2,8] [-2.9] [-1,1][1,3]
        int nums[][] = new int[][]{{-1,1},{-2,7},{-5,8},{-3,8},{1,3},{-2,9},{-5,2}};
        int longestChain = maximumLengthOfPairChain.findLongestChain(nums);
        System.out.println(longestChain);

    }
}
