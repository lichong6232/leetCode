package cn.bupt.leetCode.core;


import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:37 2019/8/6
 */
public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    private int maxPath(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftMaxPath = maxPath(root.left);
        int rightMaxPath = maxPath(root.right);
        int sum = root.val;
        if (leftMaxPath>0){
            sum+=leftMaxPath;
        }
        if (rightMaxPath>0){
            sum+=rightMaxPath;
        }
        max = Math.max(max,sum);
        return Math.max(leftMaxPath,rightMaxPath)>0?Math.max(leftMaxPath,rightMaxPath)+root.val:root.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        int maxPathSum = binaryTreeMaximumPathSum.maxPathSum(node1);
        System.out.println(maxPathSum);
    }

}
