package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:45 2019/6/1
 */
public class ConstructBinaryTreefromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildTree(int preorder[], int inorder[], int preLeftIndex, int preRightIndex, int inLeftIndex, int inRightIndex){

        if (preLeftIndex>preRightIndex){
            return null;
        }
        int value = preorder[preLeftIndex];
        int inMidIndex = inLeftIndex;
        for (;inMidIndex<=inRightIndex;inMidIndex++){
            if (inorder[inMidIndex] == value){
                break;
            }
        }
        TreeNode root = new TreeNode(value);
        root.left = buildTree(preorder,inorder,preLeftIndex+1,preLeftIndex+inMidIndex - inLeftIndex,inLeftIndex,inMidIndex-1);
        root.right = buildTree(preorder,inorder,preLeftIndex+inMidIndex - inLeftIndex+1,preRightIndex,inMidIndex+1,inRightIndex);
        return root;

    }


}
