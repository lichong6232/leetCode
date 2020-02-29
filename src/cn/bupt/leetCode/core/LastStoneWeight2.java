package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:31 2019/10/26
 */
public class LastStoneWeight2 {

    public int lastStoneWeightII(int[] stones) {

        int sum =0;
        for (int stone : stones){
            sum+=stone;
        }
        int target = sum/2;
        int n = stones.length;
        int dp[][] = new int[n+1][target+1];

        for (int i=1;i<=n;i++){
            for (int j=1;j<=target;j++){
                if (stones[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i-1]]+stones[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return sum-2*dp[n][target];
    }

    public static void main(String[] args) {
        LastStoneWeight2 lastStoneWeight2 = new LastStoneWeight2();
        int stones[] = new int[]{2,7,4,1,8,1};
        int i = lastStoneWeight2.lastStoneWeightII(stones);
        System.out.println(i);
    }
}
