package cn.bupt.leetCode;

import java.util.ArrayList;

public class PascalTriangle2 {
	
	public static void main(String[] args) {
		/*PascalTriangle2 pascalTriangle2=new PascalTriangle2();
		System.out.println(pascalTriangle2.getRow(3));*/
	}
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> res = new ArrayList<Integer>(); 
		for(int i = 0;i<rowIndex+1;i++) {
			res.add(1);
			for(int j=i-1;j>0;j--) {
				res.set(j, res.get(j-1)+res.get(j));
			}
		} 
		return res;
	}

}
