package cn.bupt.leetCode;

public class BuildTreeByInAndPost {
	
	public void preOrdre(TreeNode root){
		if(root!=null){
			System.out.println(root.val);
			preOrdre(root.left);
			preOrdre(root.right);
		}
	}
	
	public static void main(String[] args) {
		BuildTreeByInAndPost buildTreeByInAndPost=new BuildTreeByInAndPost();
		int postorder[]=new int[]{7,10,3,2,12,6,15,13,9,5,4};
		int inorder[]=new int[]{7,2,3,10,4,12,6,5,13,15,9};
		TreeNode root= buildTreeByInAndPost.buildTree(inorder, postorder);
		buildTreeByInAndPost.preOrdre(root);
	}
	
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
	        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
	 }
	 
	 private TreeNode build(int inorder[],int postorder[],int leftIn,int rightIn,int leftPost,int rightPost){
		 if(leftPost>rightPost)
			 return null;
		 int val=postorder[rightPost];
		 int mid=leftIn;
		 for(;mid<=rightIn;mid++){
			 if(inorder[mid]==val){
				 break;
			 }
		 }
		 TreeNode root=new TreeNode(val);
		 root.left=build(inorder, postorder, leftIn, mid-1, leftPost, leftPost+(mid-leftIn)-1);
		 root.right=build(inorder, postorder, mid+1, rightIn, leftPost+(mid-leftIn), rightPost-1);
		 return root;
		 
	 }

}
