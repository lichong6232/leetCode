package cn.bupt.leetCode.niuke;

public class BalancedTree {
	
	 public boolean isBalanced(TreeNode root) {
		 if(root==null)
			 return true;
		 return Math.abs(pathNumber(root.left)-pathNumber(root.right))<2&&isBalanced(root.left)&&isBalanced(root.right);
	 }
	 public int pathNumber(TreeNode root){
		 if(root==null)
			 return 0;
		 return Math.max(pathNumber(root.left), pathNumber(root.right))+1;
	 }

}
