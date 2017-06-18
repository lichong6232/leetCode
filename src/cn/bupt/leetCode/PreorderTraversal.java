package cn.bupt.leetCode;

import java.util.ArrayList;

public class PreorderTraversal {
	
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		node1.right=node2;
		node2.left=node3;
		PreorderTraversal preorderTraversal=new PreorderTraversal();
		ArrayList<Integer> list=preorderTraversal.preorderTraversal(node1);
		System.out.println(list);
		
	}

	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
		 ArrayList<Integer> list=new ArrayList<Integer>();
	        postOrder(root, list);
	        return list;
	 }
	 
	 public void postOrder(TreeNode root,ArrayList<Integer> list){
		 if(root!=null){
			 list.add(root.val);
			 postOrder(root.left, list);
			 postOrder(root.right, list);
			 
		 }
	 }
}
