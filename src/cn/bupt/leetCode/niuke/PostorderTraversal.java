package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

public class PostorderTraversal {
	
	public static void main(String[] args) {
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		node1.right=node2;
		node2.left=node3;
		PostorderTraversal postorderTraversal=new PostorderTraversal();
		ArrayList<Integer> list=postorderTraversal.postorderTraversal(node1);
		System.out.println(list);
		
	}
	
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        postOrder(root, list);
	        return list;
	 }
	 
	 public void postOrder(TreeNode root,ArrayList<Integer> list){
		 if(root!=null){
			 postOrder(root.left, list);
			 postOrder(root.right, list);
			 list.add(root.val);
		 }
	 }

}
