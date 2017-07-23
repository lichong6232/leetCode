package cn.bupt.leetCode;

public class MaxProfit1 {
	
	int buy=Integer.MIN_VALUE,profit=0; 
	public int maxProfit(int[] prices) {
        if(prices==null)
        	return  0;
        for(int price:prices){
        	buy=Math.max(buy, -price);
        	profit=Math.max(profit, buy+price);
        }
        return profit;
	 }

}
