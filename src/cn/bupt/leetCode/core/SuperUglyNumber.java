package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:50 2019/10/26
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int dp[] = new int[n];
        int pTag[] = new int[primes.length];
        dp[0]=1;
        int i=1;
        while (i<n){
            int min = Integer.MAX_VALUE;
            for (int j=0;j<primes.length;j++){
                min = Math.min(min,primes[j]*dp[pTag[j]]);
            }
            dp[i] = min;
            for (int j=0;j<primes.length;j++){
                if (dp[i]>=primes[j]*dp[pTag[j]]){
                    pTag[j]++;
                }
            }
            i++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

    public static void main(String[] args) {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        int primes[] = new int[]{2,11,13};
        int i = superUglyNumber.nthSuperUglyNumber(5, primes);
        System.out.println(i);
    }


}
