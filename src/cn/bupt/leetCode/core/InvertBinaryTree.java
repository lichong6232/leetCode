package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:08 2019/9/4
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


}
