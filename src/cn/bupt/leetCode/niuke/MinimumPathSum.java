package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:01 2019/3/28
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int rowNumber = grid.length;
        int colNumber = grid[0].length;
        int dp [][] = new int[rowNumber][colNumber];
        dp[0][0] = grid[0][0];
        for (int i=1;i<rowNumber;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int j=1;j<colNumber;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i=1;i<rowNumber;i++){
            for (int j=1;j<colNumber;j++){
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];
            }
        }
        return dp[rowNumber-1][colNumber-1];
    }

    public static void main(String[] args) {
        int grid [][] = new int[][]{{1,2,1,1},
                {2,1,3,6},{9,0,3,5},
                {4,3,7,2}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int i = minimumPathSum.minPathSum(grid);
        System.out.println(i);
    }
}
