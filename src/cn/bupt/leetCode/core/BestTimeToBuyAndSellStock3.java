package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:33 2019/7/17
 */
public class BestTimeToBuyAndSellStock3 {


    /**
     * 参考链接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
     * @param prices
     * @return
     */
    public int maxProfit1(int prices[]){
        int i10 = 0,i11=Integer.MIN_VALUE,i20 =0,i21=Integer.MIN_VALUE;
        for (int price:prices){
            i20 = Math.max(i20,i21+price);
            i21 = Math.max(i21,i10-price);
            i10 = Math.max(i10,i11+price);
            i11 = Math.max(i11,-price);
        }
        return i20;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int profit1 = 0,profit2=0;
        for (int i=0;i<prices.length;i++){
            buy1 = Math.min(buy1,prices[i]);
            profit1 = Math.max(profit1,prices[i] - buy1);
            buy2 = Math.min(buy2,prices[i]-profit1);
            profit2 = Math.max(profit2,prices[i] - buy2);
        }
        return profit2;
    }

    public static void main(String[] args) {
        int prices[] = new int[]{3,3,5,0,0,3,1,4};
        BestTimeToBuyAndSellStock3 bestTimeToBuyAndSellStock3 = new BestTimeToBuyAndSellStock3();
        int maxProfit = bestTimeToBuyAndSellStock3.maxProfit1(prices);
        System.out.println(maxProfit);
    }
}
