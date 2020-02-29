package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:50 2019/8/6
 */
public class MinimumPathSum {


    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

     Note: You can only move either down or right at any point in time.

     Example:

     Input:
     [
     [1,3,1],
     [1,5,1],
     [4,2,1]
     ]
     Output: 7
     Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length==0){
            return 0;
        }
        int rowNum = grid.length,colNum = grid[0].length;
        int dp[][] = new int[rowNum][colNum];
        dp[0][0] = grid[0][0];
        for (int i=1;i<rowNum;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j=1;j<colNum;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i=1;i<rowNum;i++){
            for (int j=1;j<colNum;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[rowNum-1][colNum-1];

    }

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int grid[][] = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int i = minimumPathSum.minPathSum(grid);
        System.out.println(i);
    }
}
