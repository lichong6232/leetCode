package cn.bupt.leetCode.niuke;

public class HasPathSum {
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root ==null)
			return false;
    	if(root.left==null&&root.right==null){
    		if(sum==root.val){
    			return true;
    		}
    	}
    	return hasPathSum(root.left, sum-root.val)|| hasPathSum(root.right, sum-root.val);
    }
	
	
}
