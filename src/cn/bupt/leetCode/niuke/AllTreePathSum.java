package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

public class AllTreePathSum {
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		TreeNode node1=new TreeNode(4);
		TreeNode node2=new TreeNode(8);
		TreeNode node3=new TreeNode(11);
		TreeNode node4=new TreeNode(13);
		TreeNode node5=new TreeNode(4);
		TreeNode node6=new TreeNode(7);
		TreeNode node7=new TreeNode(2);
		TreeNode node8=new TreeNode(5);
		TreeNode node9=new TreeNode(1);
		root.left=node1;
		root.right=node2;
		node1.left=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
		node3.right=node7;
		node5.left=node8;
		node5.right=node9;
		
		
		AllTreePathSum allTreePathSum=new AllTreePathSum();
		System.out.println(allTreePathSum.pathSum(root, 22));
		
	}

	private ArrayList<ArrayList<Integer>>  result=new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> tempList=new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		if(root==null)
			return result;
		findPath(root, sum);
		 return result;
	}
	private void findPath(TreeNode root,int sum){
		if(root==null)
			return;
		tempList.add(root.val);
		sum-=root.val;
		if(root.left==null&&root.right==null){
			if(sum==0){
				result.add(new ArrayList<Integer>(tempList));
			}
		}else{
			findPath(root.left, sum);
			findPath(root.right, sum);
			
		}
		tempList.remove(tempList.size()-1);
		
	}
}
