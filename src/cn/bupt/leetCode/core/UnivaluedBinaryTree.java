package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:43 2019/8/26
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        return (root.left == null?true:root.left.val == root.val)
                && (root.right == null?true:root.right.val == root.val)
                && isUnivalTree(root.left)
                && isUnivalTree(root.right);
    }
}
