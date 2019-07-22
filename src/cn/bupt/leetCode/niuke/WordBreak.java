package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	private boolean dp[][];
	
	public static void main(String[] args) {
		WordBreak wordBreak=new WordBreak();
		String s="catsanddog";
		Set<String> dict=new HashSet<String>(Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
		List<String> result=wordBreak.wordBreak(s, dict);
		System.out.println(result);
	}
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
	        dp=new boolean[s.length()][s.length()];
	        ArrayList<String> result=new ArrayList<String>();
	        for(int i=0;i<s.length();i++){
	        	for(int j=i;j<s.length();j++){
	        		dp[i][j]=dict.contains(s.substring(i, j+1));
	        	}
	        }
	        ArrayList<String> temp=new ArrayList<String>();
	        outPut(s.length()-1, s, temp, result);
	        return result;
	        
	}
	
	public void outPut(int i,String s,List<String> temp,List<String> result){
		if(i==-1){
			StringBuffer resultS=new StringBuffer();
			for(int k=temp.size()-1;k>=0;k--){
				resultS.append(temp.get(k));
				resultS.append(" ");
			}
			result.add(resultS.deleteCharAt(resultS.length()-1).toString());
		}else{
			for(int k=0;k<=i;k++){
				if(dp[k][i]){
					temp.add(s.substring(k, i+1));
					outPut(k-1, s, temp, result);
					temp.remove(temp.size()-1);
				}
			}
		}
		
	}
	
	 public boolean wordBreak2(String s, Set<String> dict) {
		 if(s==null||s.length()==0|| dict==null ||dict.size()==0)
			 return false;
		 
		 
		 int sLength=s.length();
		 boolean dp[]=new boolean[sLength+1];
		 dp[0]=true;
		 for(int i=1;i<=sLength;i++){
			 for(int j=0;j<i;j++){
				 if(dp[j]&&dict.contains(s.substring(j, i))){
					 dp[i]=true;
				 }
			 }
		 }
		 return dp[sLength];
	        
	 }
	

}
