package cn.bupt.leetCode.niuke.twice;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:04 2019/5/31
 */
public class SurroundedRegions {


    /***
     * Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.

     A region is captured by flipping all'O's into'X's in that surrounded region .

     For example,

     X X X X
     X O O X
     X X O X
     X O X X

     After running your function, the board should be:

     X X X X
     X X X X
     X X X X
     X O X X

     * @param board
     */
    public void solve(char[][] board) {

        if (board == null || board.length==0){
            return;
        }
        int rowNumber = board.length,colNumber = board[0].length;
        for (int j=0;j<colNumber;j++){
            dfs(board,0,j,rowNumber,colNumber);
            dfs(board,rowNumber-1,j,rowNumber,colNumber);
        }
        for (int i=0;i<rowNumber;i++){
            dfs(board,i,0,rowNumber,colNumber);
            dfs(board,i,colNumber-1,rowNumber,colNumber);
        }
        for (int i=0;i<rowNumber;i++){
            for (int j=0;j<colNumber;j++){
                if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }else {
                    board[i][j] = 'X';
                }
            }

        }

    }

    public static void main(String[] args) {
        char board[][] = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);

        for (int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }


    }

    private void dfs(char board[][], int i, int j,int rowNumber,int colNumber){
        if (i>=rowNumber || i<0 || j>=colNumber || j<0){
            return;
        }
        if (board[i][j] == 'O'){
            board[i][j] = '*';
            dfs(board,i,j+1,rowNumber,colNumber);
            dfs(board,i,j-1,rowNumber,colNumber);
            dfs(board,i+1,j,rowNumber,colNumber);
            dfs(board,i-1,j,rowNumber,colNumber);
        }

    }

}
