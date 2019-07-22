package cn.bupt.leetCode.niuke;

public class IsEqualTree {
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return check(p, q);
    }
	
	public boolean check(TreeNode p,TreeNode q){
		if(p==null&&q==null) return true;
		if((p==null&&q!=null)||(p!=null&&q==null)) return false;
		return p.val==q.val&&check(p.left, q.left)&&check(p.right, q.right);
	}

}
