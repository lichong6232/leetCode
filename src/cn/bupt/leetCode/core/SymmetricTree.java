package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:41 2019/8/8
 */
public class SymmetricTree {

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

     For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

         1
     /      \
     2       2
     / \   /  \
     3  4 4    3


     But the following [1,2,2,null,3,null,3] is not:

     1
     / \
     2   2
     \   \
     3    3

     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return same(root,root);
    }

    private boolean same(TreeNode node1, TreeNode node2){
        if ((node1 == null && node2!=null) || (node1!=null && node2 == null)){
            return false;
        }
        if (node1 == null && node2 == null){
            return true;
        }
        return node1.val == node2.val && same(node1.left,node2.right) && same(node1.right,node2.left);
    }
}
