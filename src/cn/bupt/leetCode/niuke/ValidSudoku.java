package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:57 2019/4/10
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j]!='.' && !check(board,i,j,board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
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
        ValidSudoku validSudoku = new ValidSudoku();
        boolean validSudoku1 = validSudoku.isValidSudoku(board);
        System.out.println(validSudoku1);
    }

    private boolean check(char[][] board,int row,int col,char number){
        for (int k=0;k<9;k++){

            if ((k!=col && board[row][k]==number) || (k!=row && board[k][col] == number)){
                return false;
            }
        }
        int tmpRow = row/3;
        int tmpCol = col/3;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (3*tmpRow+i==row && 3*tmpCol+j==col){
                    continue;
                }
                if (board[3*tmpRow+i][3*tmpCol+j] == number){
                    return false;
                }
            }
        }
        return true;
    }
}
