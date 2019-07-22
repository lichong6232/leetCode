package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:09 2019/7/18
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 参考连接：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int i10 = 0,i11 = Integer.MIN_VALUE;
        for (int price:prices){
            i10 = Math.max(i10,i11+price);
            i11 = Math.max(i11,-price);
        }
        return i10;
    }

    public static void main(String[] args) {
        int prices [] ={7,1,5,3,6,4};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int maxProfit = bestTimeToBuyAndSellStock.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
