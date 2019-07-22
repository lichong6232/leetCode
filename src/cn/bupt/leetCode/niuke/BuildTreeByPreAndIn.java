package cn.bupt.leetCode.niuke;

public class BuildTreeByPreAndIn {
	
	public void preOrdre(TreeNode root){
		if(root!=null){
			System.out.println(root.val);
			preOrdre(root.left);
			preOrdre(root.right);
		}
	}
	
	public static void main(String[] args) {
		int preorder[]=new int[]{4,2,7,3,10,5,6,12,9,13,15};
		int inorder[]=new int[]{7,2,3,10,4,12,6,5,13,15,9};
		BuildTreeByPreAndIn buildTreeByPreAndIn=new BuildTreeByPreAndIn();
		TreeNode root=buildTreeByPreAndIn.buildTree(preorder, inorder);
		buildTreeByPreAndIn.preOrdre(root);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
	public TreeNode build(int preorder[],int inorder[],int leftPre,int rightPre,int leftIn,int rightIn){
		if(leftPre>rightPre)
			return null;
		int val=preorder[leftPre];
		int mid=leftIn;
		for(;mid<=rightIn;mid++){
			if(inorder[mid]==val){
				break;
			}
		}
		TreeNode root=new TreeNode(val);
		root.left=build(preorder, inorder, leftPre+1, leftPre+(mid-leftIn), leftIn, mid-1);
		root.right=build(preorder, inorder, leftPre+(mid-leftIn)+1, rightPre, mid+1, rightIn);
		return root;
	}

}
