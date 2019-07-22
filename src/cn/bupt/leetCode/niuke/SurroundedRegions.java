package cn.bupt.leetCode.niuke;

import java.util.Arrays;

public class SurroundedRegions {
	
	public static void main(String[] args) {
		char board[][]={{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}};
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		surroundedRegions.solve(board);
		for(int i=0;i<board.length;i++){
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	public void solve(char[][] board) {
		if(board == null || board.length ==0)
			return;
		int rowNumber = board.length;
		int colNumber = board[0].length;
		for(int i=0;i<colNumber;i++){
			dfs(board,0,i,rowNumber,colNumber);
			dfs(board,rowNumber-1,i,rowNumber,colNumber);
		}
		for(int i=0;i<rowNumber;i++){
			dfs(board,i,0,rowNumber,colNumber);
			dfs(board,i,colNumber-1,rowNumber,colNumber);
		}
		for(int i=0;i<rowNumber;i++){
			for(int j=0;j<colNumber;j++){
				if(board[i][j]!='*'){
					board[i][j]='X';
				}else {
					board[i][j]='O';
				}
			}
		}
    }
	
	public void dfs(char board[][],int row,int col,int rowNumber,int colNumber){
		if(row<0 || row >= rowNumber || col<0 || col>= colNumber){
			return;
		}
		if(board[row][col]=='O'){
			board[row][col]='*';
			dfs(board,row-1,col,rowNumber,colNumber);
			dfs(board,row+1,col,rowNumber,colNumber);
			dfs(board,row,col+1,rowNumber,colNumber);
			dfs(board,row,col-1,rowNumber,colNumber);
		}
		
	}

}
