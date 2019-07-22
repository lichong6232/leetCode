package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:31 2019/4/9
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(0,0,board);

    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char board[][]= new char[][]{
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        sudokuSolver.solveSudoku(board);
        sudokuSolver.out(board);

    }

    private  void out(char[][] board){
        for (int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private boolean solve(int i,int j,char[][] board){
        if (j==board[0].length){
            i++;
            j=0;
        }
        if (i == board.length){
            return true;
        }

        if (board[i][j]!='.'){
            return solve(i,j+1,board);
        }else {
            for (char n='1';n<='9';n+=1){
                if (check(board,i,j,n)){
                    board[i][j] = n;
                    if (solve(i, j + 1, board)){
                        return true;
                    }
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board,int row,int col,char number){
        for (int k=0;k<9;k++){
            if (board[row][k]==number || board[k][col] == number){
                return false;
            }
        }
        row /=3;
        col /=3;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (board[3*row+i][3*col+j] == number){
                    return false;
                }
            }
        }
        return true;
    }
}
