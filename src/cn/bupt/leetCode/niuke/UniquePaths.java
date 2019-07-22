package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:33 2019/3/28
 */
public class UniquePaths {

    int path;
    public int uniquePaths(int m, int n) {

        boolean tag [][] = new boolean[m][n];
        move(0,0,m,n);
        return path;

    }

    private void move(int i,int j,int m,int n){
        if (i>m || j >n){
            return;
        }
        if (i==m-1 && j==n-1){
            path++;
        }else {
            move(i+1,j,m,n);
            move(i,j+1,m,n);
        }
    }

    public int uniquePaths1(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for (int j=0;j<n;j++){
            dp[0][j]=1;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];

    }


    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int paths = uniquePaths.uniquePaths1(5, 5);
        System.out.println(paths);

    }
}
