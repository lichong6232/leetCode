package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:59 2019/5/31
 */
public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length<2){
            return 0;
        }
        int max = 0;
        for (int i=1;i<prices.length;i++){
            int temp = prices[i] - prices[i-1];
            if (temp>0){
                max += temp;
            }
        }
        return max;
    }
}
