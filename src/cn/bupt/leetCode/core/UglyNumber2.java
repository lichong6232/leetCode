package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:39 2019/10/26
 */
public class UglyNumber2 {

    public int nthUglyNumber(int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        int num2 = 0;
        int num3 = 0;
        int num5 = 0;
        int i=1;
        while (i<n){
            dp[i] = Math.min(2*dp[num2],Math.min(3*dp[num3],5*dp[num5]));
            if (dp[i]>=2*dp[num2]){
                num2++;
            }
            if (dp[i]>=3*dp[num3]){
                num3++;
            }
            if (dp[i]>=5*dp[num5]){
                num5++;
            }
            i++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }


    public static void main(String[] args) {
        UglyNumber2 uglyNumber2 = new UglyNumber2();
        int i = uglyNumber2.nthUglyNumber(10);
        System.out.println(i);
    }


}
