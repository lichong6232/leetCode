package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:58 2019/8/8
 */
public class SameTree {

    /**
     * Given two binary trees, write a function to check if they are the same or not.

     Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

     Example 1:

     Input:     1         1
     / \       / \
     2   3     2   3

     [1,2,3],   [1,2,3]

     Output: true
     Example 2:

     Input:     1         1
     /           \
     2             2

     [1,2],     [1,null,2]

     Output: false
     Example 3:

     Input:     1         1
     / \       / \
     2   1     1   2

     [1,2,1],   [1,1,2]

     Output: false
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q== null){
            return true;
        }
        if ((p==null && q!=null) || (p!=null && q == null)){
            return false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}