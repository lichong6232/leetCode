package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

public class PascalTriangle {
	
	public static void main(String[] args) {
		PascalTriangle pascalTriangle=new PascalTriangle();
		System.out.println(pascalTriangle.generate(5));
	}
	
	 public ArrayList<ArrayList<Integer>> generate(int numRows) {
	        ArrayList<ArrayList<Integer>> resultList=new ArrayList<ArrayList<Integer>>();
	        for(int i=0;i<numRows;i++){
	        	ArrayList<Integer> list=new ArrayList<Integer>();
	        	for(int j=0;j<=i;j++){
	        		if(j==0 || j==i){
	        			list.add(1);
	        		}else{
	        			list.add(resultList.get(i-1).get(j-1)+resultList.get(i-1).get(j));
	        		}
	        	}
	        	resultList.add(list);
	        }
	        return resultList;
	 }

}
