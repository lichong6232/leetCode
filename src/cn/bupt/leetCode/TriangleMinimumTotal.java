package cn.bupt.leetCode;
import java.util.*;
public class TriangleMinimumTotal {
	
	public static void main(String[] args) {
		ArrayList<Integer> list1=new ArrayList<Integer>();
		list1.add(2);
		ArrayList<Integer> list2=new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		ArrayList<Integer> list3=new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		ArrayList<Integer> list4=new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		ArrayList<ArrayList<Integer>> list =new ArrayList<ArrayList<Integer>>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		TriangleMinimumTotal triangleMinimumTotal=new TriangleMinimumTotal();
		System.out.println(triangleMinimumTotal.minimumTotal(list));
		
		
	}
	
	public int minimumTotal1(ArrayList<ArrayList<Integer>> triangle) {
		int dp[][]=new int[triangle.size()][];
		ArrayList<Integer> first=triangle.get(0);
		dp[0]=new int[first.size()];
		dp[0][0]=first.get(0);
		for(int i=1;i<triangle.size();i++){
			ArrayList<Integer> list=triangle.get(i);
			int size=list.size();
			dp[i]=new int[size];
			dp[i][0]=dp[i-1][0]+list.get(0);
			dp[i][size-1]=dp[i-1][dp[i-1].length-1]+list.get(size-1);
			for(int j=1;j<size-1;j++){
				dp[i][j]=list.get(j)+Math.min(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		int min=Integer.MAX_VALUE;
		for(int j=0;j<triangle.get(triangle.size()-1).size();j++){
			if(min>dp[triangle.size()-1][j]){
				min=dp[triangle.size()-1][j];
			}
		}
		return min;
    }
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		
		for(int i=triangle.size()-2;i>=0;i--){
			for(int j=0;j<triangle.get(i).size();j++){
				triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
			}
		}
		return triangle.get(0).get(0);
	}

}
