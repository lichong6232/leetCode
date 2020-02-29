package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:27 2019/9/14
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row+1][col+1];
        int maxSquare = 0;
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                    maxSquare = Math.max(maxSquare,dp[i][j]);
                }
            }
        }
        return maxSquare*maxSquare;
    }
}
