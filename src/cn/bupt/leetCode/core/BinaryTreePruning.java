package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:49 2019/9/4
 */
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        remove(root);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreePruning binaryTreePruning = new BinaryTreePruning();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        node1.right = node2;
        node2.left = node3;
        node2.right = node4;
        binaryTreePruning.remove(node1);
        visit(node1);

    }

    private static void visit(TreeNode root){
        if (root!=null){
            System.out.println(root.val);
            visit(root.left);
            visit(root.right);
        }
    }

    private boolean remove(TreeNode node){
        if (node == null){
            return true;
        }
        boolean leftRemove = remove(node.left);
        boolean rightRemove = remove(node.right);
        if (leftRemove){
            node.left = null;
        }
        if (rightRemove){
            node.right = null;
        }
        return leftRemove&&rightRemove&&node.val==0;

    }
}
