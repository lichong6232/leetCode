package cn.bupt.leetCode.niuke;

public class MaxPathSum {
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(-5);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(9);
		node1.left=node2;
		node1.right=node3;
		node3.left=node5;
		node3.right=node4;
		node4.left=node6;
		MaxPathSum maxPathSum=new MaxPathSum();
		System.out.println(maxPathSum.maxPathSum(node1));
		
	}
	public int maxPathSum(TreeNode root) {
        if(root==null)
        	return 0;
        maxSum(root);
        return max;
    }
	int max=Integer.MIN_VALUE;
	public int maxSum(TreeNode root){
		if(root == null)
			return 0;
		int leftVal = maxSum(root.left);
		int rightVal = maxSum(root.right);
		int sum = root.val;
		if (leftVal>0) {
			sum+=leftVal;
		}
		if (rightVal>0) {
			sum+=rightVal;
		}
		if(max<sum)
			max=sum;
		return Math.max(leftVal, rightVal)>0?Math.max(leftVal, rightVal)+root.val:root.val;
	}

}
