package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:41 2019/8/6
 */
public class UniquePaths2 {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

     The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

     Now consider if some obstacles are added to the grids. How many unique paths would there be?



     An obstacle and empty space is marked as 1 and 0 respectively in the grid.

     Note: m and n will be at most 100.

     Example 1:

     Input:
     [
     [0,0,0],
     [0,1,0],
     [0,0,0]
     ]
     Output: 2
     Explanation:
     There is one obstacle in the middle of the 3x3 grid above.
     There are two ways to reach the bottom-right corner:
     1. Right -> Right -> Down -> Down
     2. Down -> Down -> Right -> Right
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0){
            return 0;
        }
        int rowNum = obstacleGrid.length,colNum = obstacleGrid[0].length;
        int dp[][] = new int[rowNum][colNum];
        for (int i=0;i<rowNum;i++){
            if (obstacleGrid[i][0]==1){
                break;
            }
            dp[i][0]=1;

        }
        for (int j=0;j<colNum;j++){
            if (obstacleGrid[0][j]==1){
                break;
            }
            dp[0][j]=1;
        }
        for (int i=1;i<rowNum;i++){
            for (int j=1;j<colNum;j++){
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[rowNum-1][colNum-1];

    }

    public static void main(String[] args) {
        UniquePaths2 uniquePaths2 = new UniquePaths2();
        int obstacleGrid[][] = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        int i = uniquePaths2.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

}
