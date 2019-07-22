package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:09 2019/7/16
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backTrace(board,0,0);
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char board[][] = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        sudokuSolver.solveSudoku(board);
        for (int i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private boolean backTrace(char board[][],int row,int col){

        if (col == board[0].length){
            row++;
            col = 0;
        }
        if (row == board.length){
            return true;
        }
        if (board[row][col]!='.'){
            return backTrace(board,row,col+1);
        }
        for (char c='1';c<='9';c++){
            if (check(board,row,col,c)){
                board[row][col] = c;
                if (backTrace(board,row,col+1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;

    }

    private boolean check(char board[][],int row,int col,int num){
        for (int j=0;j<board[0].length;j++){
            if (j == col || board[row][j] == '.'){
                continue;
            }
            if (board[row][j] == num){
                return false;
            }
        }
        for (int i=0;i<board.length;i++){
            if (i == row || board[i][col] == '.'){
                continue;
            }
            if (board[i][col] == num){
                return false;
            }
        }
        int gradRow = row/3*3,gradCol = col/3*3;

        for (int i=gradRow;i<gradRow+3;i++){
            for (int j = gradCol;j<gradCol+3;j++){
                if ((i == row && j==col) || board[i][j] == '.'){
                    continue;
                }
                if (board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
