package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:25 2019/9/8
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return recursion(root,null,null);
    }

    private boolean recursion(TreeNode root,Integer lower,Integer upper){
        if (root == null){
            return true;
        }
        if (lower!=null && root.val<=lower){
            return false;
        }
        if (upper!=null && root.val>=upper){
            return false;
        }
        if (!(recursion(root.left,lower,root.val))){
            return false;
        }
        if (!(recursion(root.right,root.val,upper))){
            return false;
        }
        return true;

    }




    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node6 = new TreeNode(6);
        TreeNode node20 = new TreeNode(20);
        node10.left = node5;
        node10.right = node15;
        node15.left = node6;
        node15.right = node20;
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean validBST = validateBinarySearchTree.isValidBST(node10);
        System.out.println(validBST);
    }
}
