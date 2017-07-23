package cn.bupt.leetCode;

public class MaxProfit2 {
	int maxProfit=0;
	public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)
        	return maxProfit;
        for(int i=1;i<prices.length;i++){
        	int temp=prices[i]-prices[i-1];
        	if(temp>0)
        		maxProfit+=temp;
        }
        return maxProfit;
    }

}
