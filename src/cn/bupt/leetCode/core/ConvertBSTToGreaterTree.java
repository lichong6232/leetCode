package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:43 2019/8/27
 */
public class ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        recursion(root);
        return root;
    }
    int sum;
    private TreeNode recursion(TreeNode currentRoot){
        if (currentRoot == null){
            return null;
        }
        recursion(currentRoot.right);
        sum+= currentRoot.val;
        currentRoot.val = sum;
        recursion(currentRoot.left);
        return currentRoot;
    }

    public static void main(String[] args) {
        ConvertBSTToGreaterTree convertBSTToGreaterTree = new ConvertBSTToGreaterTree();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(-4);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        TreeNode node = convertBSTToGreaterTree.convertBST(node1);
        visit(node);
    }
    private static void visit(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        visit(root.left);
        visit(root.right);
    }
}
