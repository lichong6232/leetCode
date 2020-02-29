package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:07 2019/10/26
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        int rootValue =root.val;
        int pValue = p.val;
        int qValue = q.val;
        if (pValue>rootValue && qValue>rootValue){
            return lowestCommonAncestor(root.right,p,q);
        }
        if (pValue<rootValue && qValue<rootValue){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int pValue = p.val;
        int qValue = q.val;
        TreeNode node = root;
        while (node!=null){
            int rootValue = node.val;
            if (pValue <rootValue && qValue<rootValue){
                node = node.left;
            }else if (pValue>rootValue && qValue>rootValue){
                node = node.right;
            }else {
                return node;
            }
        }
        return null;
    }


}
