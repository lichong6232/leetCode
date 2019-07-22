package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:05 2019/5/31
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Say you have an array for which the i th element is the price of a given stock on day i.

     If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.


     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null){
            return 0;
        }
        int buy=Integer.MAX_VALUE,profit = 0;
        for (int price : prices){
            buy = Math.min(buy,price);
            profit = Math.max(profit,price-buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int prices[] = {2,3,4,7,1,10};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));

    }
}
