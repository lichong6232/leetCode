package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:38 2019/3/28
 */
public class ClimbingStairs {

    /**
     * 问题描述：
     * You are climbing a stair case. It takes n steps to reach to the top.

     Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * @param n
     * @return
     */

    /**
     * 递归的方法
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n<=1){
            return 1;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    /**
     * 动态规划的方法
     * @param n
     * @return
     */
    public int climbStairs1(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int i = climbingStairs.climbStairs1(3);
        System.out.println(i);
    }
}
