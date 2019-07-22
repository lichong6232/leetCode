package cn.bupt.leetCode.niuke;

public class IsMirror {
	
	public static void main(String[] args) {
		IsMirror isMirror=new IsMirror();
		TreeNode root=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(2);
		
		root.left=node1;
		root.right=node2;
		System.out.println(isMirror.isSymmetric(root));
	}
	
	public boolean isSymmetric(TreeNode root) {
		return check(root, root);
    }
	
	private boolean check(TreeNode left,TreeNode right){
		if(left==null&&right==null) return true;
		if((left==null&&right!=null) || (left!=null&&right==null)) return false;
		return left.val==right.val&&check(left.left, right.right)&&check(left.right, right.left);
		
	}

}
