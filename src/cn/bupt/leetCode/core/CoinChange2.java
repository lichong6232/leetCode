package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:29 2019/10/27
 */
public class CoinChange2 {

    int ans;
    public int change(int amount, int[] coins) {
        dfs(coins,0,amount,0);
        return ans;
    }


    public int change2(int amount, int[] coins) {
        int dp[][] = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for (int i=1;i<=coins.length;i++){
            for (int j=0;j<=amount;j++){
                for (int k=0;j-k*coins[i-1]>=0;k++){
                    dp[i][j] += dp[i-1][j-k*coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        int coins[] = new int[]{1,2,5};
        int change = coinChange2.change2(11, coins);
        System.out.println(change);
    }

    private void dfs(int coins[],int start,int amount,int temp){
        if (temp>amount){
            return;
        }
        if (temp == amount){
            ans++;
            return;
        }
        for (int i=start;i<coins.length;i++){
            dfs(coins,i,amount,temp+coins[i]);
        }
    }
}
