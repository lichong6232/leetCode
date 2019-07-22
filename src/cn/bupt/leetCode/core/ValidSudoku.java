package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:05 2019/7/16
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<board.length;i++){
            for (int j =0;j<board[i].length;j++){
                if (board[i][j] == '.'){
                    continue;
                }
                if (!check(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char board[][] = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        boolean validSudoku1 = validSudoku.isValidSudoku(board);
        System.out.println(validSudoku1);
    }



    private boolean check(char board[][],int row,int col){
        for (int j=0;j<board[0].length;j++){
            if (j == col || board[row][j] == '.'){
                continue;
            }
            if (board[row][j] == board[row][col]){
                return false;
            }
        }
        for (int i=0;i<board.length;i++){
            if (i == row || board[i][col] == '.'){
                continue;
            }
            if (board[i][col] == board[row][col]){
                return false;
            }
        }
        int gradRow = row/3*3,gradCol = col/3*3;

        for (int i=gradRow;i<gradRow+3;i++){
            for (int j = gradCol;j<gradCol+3;j++){
                if ((i == row && j==col) || board[i][j] == '.'){
                    continue;
                }
                if (board[i][j] == board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }


}
