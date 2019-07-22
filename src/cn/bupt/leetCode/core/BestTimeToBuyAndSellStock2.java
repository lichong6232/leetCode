package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:44 2019/7/16
 */
public class BestTimeToBuyAndSellStock2 {


    /**
     * 参考解题：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
     * @param prices
     * @return
     */
    public int maxProfit1(int prices[]){
        int ik0=0,ik1=Integer.MIN_VALUE;
        for (int price : prices){
            int ik0_old = ik0;
            ik0 = Math.max(ik0,ik1+price);
            ik1 = Math.max(ik1,ik0_old-price);
        }
        return ik0;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }

        int buy = prices[0];
        int maxProfix = 0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]>buy){
                maxProfix += (prices[i] - buy);
                buy=prices[i];
            }else {
                buy = prices[i];
            }
        }
        return maxProfix;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        int price[] = new int[]{1,2,3,4,5};
        int maxProfit = bestTimeToBuyAndSellStock2.maxProfit1(price);
        System.out.println(maxProfit);
    }

}
