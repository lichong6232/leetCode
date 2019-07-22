package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:52 2019/6/1
 */
public class BalancedBinaryTree {

    /**
     * Given a binary tree, determine if it is height-balanced.

     For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(deep(root.left)-deep(root.right)) <2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int deep(TreeNode node){
        if (node == null){
            return 0;
        }
        return Math.max(deep(node.left),deep(node.right))+1;
    }

}
