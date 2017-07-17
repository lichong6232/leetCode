package cn.bupt.leetCode;

public class MaxPath {

	public int maxDepth(TreeNode root) {
        if(root==null)
        	return 0;
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return 1+(leftDepth>rightDepth?leftDepth:rightDepth);
    }
}
