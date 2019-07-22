package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:25 2019/7/19
 */
public class BestTimeToBuyAndSellStockWithCooldown {


    public int maxProfit(int[] prices) {
        int ik0 =0,ik1=Integer.MIN_VALUE;
        int pre_ik0=0;
        for (int price:prices){
            int ik0_old = ik0;
            ik0 = Math.max(ik0,ik1+price);
            ik1 = Math.max(ik1,pre_ik0-price);
            pre_ik0 = ik0_old;
        }
        return ik0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown bestTimeToBuyAndSellStockWithCooldown = new BestTimeToBuyAndSellStockWithCooldown();
        int prices[] = new int[]{1,2,3,0,2};
        int maxProfit = bestTimeToBuyAndSellStockWithCooldown.maxProfit(prices);
        System.out.println(maxProfit);
    }

}
