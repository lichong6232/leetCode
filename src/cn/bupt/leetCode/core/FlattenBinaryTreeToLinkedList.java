package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:00 2019/8/27
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if (root.left!=null){
            TreeNode right = root.right;
            root.right = root.left;
            TreeNode curr = root.left;
            while (curr.right!=null){
                curr = curr.right;
            }
            curr.right = right;
            root.left = null;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(node1);
        visit(node1);

    }

    private static void visit(TreeNode root){
        if (root!=null){
            System.out.println(root.val);
            visit(root.left);
            visit(root.right);
        }
    }
}
