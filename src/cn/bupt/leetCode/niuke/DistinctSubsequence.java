package cn.bupt.leetCode.niuke;

public class DistinctSubsequence {
	
	public static void main(String[] args) {
		String S="rabbbit";
		String T="rabbit";
		DistinctSubsequence distinctSubsequence=new DistinctSubsequence();
		System.out.println(distinctSubsequence.numDistinct(S, T));
	}
	
	 public int numDistinct(String S, String T) {
		 int row=S.length()+1;
		 int col=T.length()+1;
		 int dp[][]=new int[row][col];
		 for(int i=0;i<row;i++){
			 dp[i][0]=1;
		 }
		 for(int i=1;i<row;i++){
			 for(int j=1;j<col;j++){
				 if(S.charAt(i-1)==T.charAt(j-1)){
					 dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				 }else{
					 dp[i][j]=dp[i-1][j];
				 }
			 }
		 }
		 return dp[row-1][col-1];
	 }

}
