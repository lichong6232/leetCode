package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:47 2019/8/26
 */
public class MaximumWidthOfBinaryTree {

    /**
     * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

     The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

     Example 1:

     Input:

     1
     /   \
     3     2
     / \     \
     5   3     9

     Output: 4
     Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,new HashMap<>(),0,1);
        return maxWidth;
    }
    int maxWidth = 0;
    private void dfs(TreeNode root,Map<Integer,Integer> left,int level,int pos){
        if (root == null){
            return;
        }
        left.putIfAbsent(level,pos);
        int leftPos = left.get(level);
        maxWidth = Math.max(maxWidth,pos-leftPos+1);
        dfs(root.left,left,level+1,2*pos);
        dfs(root.right,left,level+1,2*pos+1);
    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node3.left = node5;
        node2.left = node4;
        node3.right = node5;
        node4.left = node6;
        node5.right = node7;
        int i = maximumWidthOfBinaryTree.widthOfBinaryTree(node1);
        System.out.println(i);
    }
}
