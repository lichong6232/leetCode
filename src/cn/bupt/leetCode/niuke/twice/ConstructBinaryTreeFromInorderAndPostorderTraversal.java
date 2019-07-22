package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:02 2019/6/1
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {


    /**
     * 问题描述：
     * Given inorder and postorder traversal of a tree, construct the binary tree.

     Note:
     You may assume that duplicates do not exist in the tree.
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    private TreeNode buildTree(int inorder[], int postorder[], int inLeftIndex, int inRightIndex, int postLeftIndex,int postRightIndex){
        if (postLeftIndex > postRightIndex){
            return null;
        }
        int value  = postorder[postRightIndex];
        int inMidIndex = inLeftIndex;
        for (;inMidIndex<=inRightIndex;inMidIndex++){
            if (inorder[inMidIndex] == value){
                break;
            }
        }
        TreeNode root = new TreeNode(value);
        root.left = buildTree(inorder,postorder,inLeftIndex,inMidIndex-1,postLeftIndex,postRightIndex+(inMidIndex-inLeftIndex)-1);
        root.right = buildTree(inorder,postorder,inMidIndex+1,inRightIndex,postRightIndex+(inMidIndex-inLeftIndex),postRightIndex);
        return root;
    }
}
