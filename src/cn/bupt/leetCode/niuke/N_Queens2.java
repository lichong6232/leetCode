package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:34 2019/4/2
 */
public class N_Queens2 {


    /**
     * 问题描述：
     *Follow up for N-Queens problem.

     Now, instead outputting board configurations, return the total number of distinct solutions.

     * @param n
     * @return
     */
    int total;
    public int totalNQueens(int n) {
        int col[] = new int[n];
        place(0,n,col);
        return total;
    }

    private void place(int k,int n,int col[]){
        if (k==n){
            total++;
        }else {
            for (int i=0;i<n;i++){
                if (check(k,i,col)){
                    col[k] = i;
                    place(k+1,n,col);
                }
            }
        }

    }

    private boolean check(int k,int row, int col[]){
        for (int i=0;i<k;i++){
            if (col[i]==row){
                return false;
            }
            //处于从左下到(row,k)坐标对角线上
            if (i+col[i] == k+row){
                return false;
            }
            //处于从左上到(row,k)坐标的对角线上
            if (i-col[i] == k-row){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N_Queens2 n_queens2 = new N_Queens2();
        int i = n_queens2.totalNQueens(4);
        System.out.println(i);
    }


}
