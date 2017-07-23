package cn.bupt.leetCode;

public class SortedArrayToBST {
	
	public static void main(String[] args) {
		int num[]=new int[]{1,3};
		SortedArrayToBST sortedArrayToBST=new SortedArrayToBST();
		System.out.println(sortedArrayToBST.sortedArrayToBST(num).val);
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
        return buildTree(num, 0, num.length-1);
    }
	
	private TreeNode buildTree(int num[],int left,int right){
		if(left>right)
			return null;
		if(left==right)
			return new TreeNode(num[left]);
		int mid=(left+right)/2+(left+right)%2;
		TreeNode root=new TreeNode(num[mid]);
		root.left=buildTree(num, left, mid-1);
		root.right=buildTree(num, mid+1, right);
		return root;
	}
}
