package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:02 2019/5/31
 */
public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length<2){
            return 0;
        }
        int buy1 = Integer.MAX_VALUE,buy2 = Integer.MAX_VALUE,profit1 = 0,profit2 = 0;
        for (int price : prices){
            buy1 = Math.min(buy1,price);
            profit1 = Math.max(profit1,price-buy1);
            buy2 = Math.min(buy2,price - profit1);
            profit2 = Math.max(profit2,price - buy2);
        }
        return profit2;
    }
}
