package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:52 2019/9/8
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right))<2;
    }

    private int height(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

}
