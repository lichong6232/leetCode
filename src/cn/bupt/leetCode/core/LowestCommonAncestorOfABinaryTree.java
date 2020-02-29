package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:25 2019/10/26
 */
public class LowestCommonAncestorOfABinaryTree {


    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }


    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        TreeNode node = lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(node1, node2, node9);
        System.out.println(node.val);
    }

    private boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if (root ==null){
            return false;
        }
        int left = dfs(root.left,p,q)?1:0;
        int riht = dfs(root.right,p,q)?1:0;
        int mid = (root.val == p.val || root.val == q.val)?1:0;
        if (left+riht+mid==2){
            ans = root;
        }
        return left+riht+mid>0;
    }


}
