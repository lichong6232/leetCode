package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:52 2019/10/26
 */
public class TreeMaxLengthPath {

    int ans= 0;
    public int maxLengthPath(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftLength = maxLengthPath(root.left);
        int rightLength = maxLengthPath(root.right);
        ans = Math.max(ans,leftLength+rightLength+1);
        return Math.max(leftLength,rightLength)+1;
    }

    public static void main(String[] args) {
        TreeMaxLengthPath treeMaxLengthPath = new TreeMaxLengthPath();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
        node8.right = node9;
        treeMaxLengthPath.maxLengthPath(node1);
        System.out.println(treeMaxLengthPath.ans);

    }
}
