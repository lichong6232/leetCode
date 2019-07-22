package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:27 2019/3/28
 */
public class UniquePath2 {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for (int i=0;i<m && obstacleGrid[i][0]!=1;i++){
            dp[i][0]=1;
        }
        for (int j=0;j<n &&  obstacleGrid[0][j]!=1;j++){
            dp[0][j]=1;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (obstacleGrid[i][j]==0){
                    if (obstacleGrid[i][j-1]==0){
                        dp[i][j] += dp[i][j-1];
                    }
                    if ( obstacleGrid[i-1][j]==0){
                        dp[i][j] += dp[i-1][j];
                    }
                }


            }
        }
        return dp[m-1][n-1];
    }

    /*private int move(int i,int j,int obstracleGrid[][]){
        if (i>=obstracleGrid.length || j>=obstracleGrid[0].length || obstracleGrid[i][j]==1){
            return 0;
        }
        if (i==obstracleGrid.length-1 && j==obstracleGrid[0].length-1){
           return 1;
        }

        return move(i,j+1,obstracleGrid)+move(i+1,j,obstracleGrid);
    }*/

    public static void main(String[] args) {
        UniquePath2 uniquePath2 = new UniquePath2();
        int a[][] = new int[][]{{0,0},{0,1}};
        int i = uniquePath2.uniquePathsWithObstacles(a);
        System.out.println(i);

    }
}
