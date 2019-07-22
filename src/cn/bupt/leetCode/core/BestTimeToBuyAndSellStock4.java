package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:04 2019/7/18
 */
public class BestTimeToBuyAndSellStock4 {

    /**
     * 参考链接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k>=prices.length/2){
            int ik0 = 0,ik1 = Integer.MIN_VALUE;
            for (int price:prices){
                int ik0_old = ik0;
                ik0 = Math.max(ik0,ik1+price);
                ik1 = Math.max(ik1,ik0_old-price);
            }
            return ik0;
        }
        int ik0[] = new int[k+1];
        int ik1[] = new int[k+1];
        Arrays.fill(ik1,Integer.MIN_VALUE);
        for (int price:prices){
            for (int i=k;i>0;i--){
                ik0[i] = Math.max(ik0[i],ik1[i]+price);
                ik1[i] = Math.max(ik1[i],ik0[i-1]-price);
            }
        }
        return ik0[k];
    }

    public static void main(String[] args) {
        int prices[] = new int[]{3,3,5,0,0,3,1,4};
        BestTimeToBuyAndSellStock4 bestTimeToBuyAndSellStock4 = new BestTimeToBuyAndSellStock4();
        int maxProfit = bestTimeToBuyAndSellStock4.maxProfit(2, prices);
        System.out.println(maxProfit);
    }
}
