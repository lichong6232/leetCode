package cn.bupt.leetCode;


public class MinimumDepthOfBinaryTree {
	
	 public int run(TreeNode root) {
		 if(root!=null){
			 if(root.left!=null&&root.right!=null){
				 return Math.min(run(root.left),run(root.right))+1;
			 }else if(root.left!=null){
				 return run(root.left)+1;
			 }else if(root.right!=null){
				 return run(root.right)+1;
			 }else{
				 return 1;
			 }
			
		 }
		 return 0;
	 }

}
