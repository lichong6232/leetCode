package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:36 2019/4/2
 */
public class N_Queens {


    /**
     * 问题描述：
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



     Given an integer n, return all distinct solutions to the n-queens puzzle.

     Each solution contains a distinct board configuration of the n-queens' placement, where'Q'and'.'both indicate a queen and an empty space respectively.

     For example,
     There exist two distinct solutions to the 4-queens puzzle:

     [
     [".Q..",  // Solution 1
     "...Q",
     "Q...",
     "..Q."],

     ["..Q.",  // Solution 2
     "Q...",
     "...Q",
     ".Q.."]
     ]
     * @param n
     * @return
     */
    public ArrayList<String[]> solveNQueens(int n) {
        int col[] = new int[n];
        ArrayList<String[]> result = new ArrayList<>();
        place(0,n,col,result);
        return result;
    }

    public static void main(String[] args) {
        N_Queens n_queens = new N_Queens();
        ArrayList<String[]> result = n_queens.solveNQueens(4);
        for (String[] strings : result){
            System.out.println(Arrays.toString(strings));
        }
    }

    private String[] toString(int col[]){
        String s[] = new String[col.length];
        for (int i=0;i<col.length;i++){
            StringBuilder stringBuilder = new StringBuilder();
            for (int j=0;j<col.length;j++){
                if (j==col[i]){
                    stringBuilder.append("Q");
                }else {
                    stringBuilder.append(".");
                }
            }
            s[i] = stringBuilder.toString();
        }
        return s;
    }

    private void place(int k,int n,int col[],ArrayList<String[]> result){
        if (k==n){
            result.add(toString(col));
        }else {
            for (int i=0;i<n;i++){
                if (check(i,col,k)){
                    col[k] = i;
                    place(k+1,n,col,result);
                }
            }
        }
    }
    private boolean check(int row,int col[],int k){
        for (int i=0;i<k;i++){
            if (col[i] == row){
                return false;
            }
            if (i-col[i] == k-row){
                return false;
            }
            if (i+col[i] == k+row){
                return false;
            }
        }
        return true;
    }
}
