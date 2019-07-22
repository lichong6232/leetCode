package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:42 2019/7/19
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int ik0=0,ik1=Integer.MIN_VALUE;
        for (int price:prices){
            int ik0_old = ik0;
            ik0 = Math.max(ik0,ik1+price);
            ik1 = Math.max(ik1,ik0_old-price-fee);
        }
        return ik0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee bestTimeToBuyAndSellStockWithTransactionFee = new BestTimeToBuyAndSellStockWithTransactionFee();
        int prices[] = new int[]{1, 3, 2, 8, 4, 9};
        int maxProfit = bestTimeToBuyAndSellStockWithTransactionFee.maxProfit(prices, 2);
        System.out.println(maxProfit);
    }
}
