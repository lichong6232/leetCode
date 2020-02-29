package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:24 2019/9/1
 */
public class BinaryTreeCameras {

    /**
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {

        int stat = stat(root);
        if (stat == 0){
            return minCameras+1;
        }
        return minCameras;
    }
    private int minCameras = 0;
    private int stat(TreeNode root){
        if (root == null){
            return 1;
        }
        int leftStat = stat(root.left);
        int rightStat = stat(root.right);
        if (leftStat ==0 || rightStat == 0){
            minCameras ++;
            return 2;
        }
        if (leftStat == 1 && rightStat == 1){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.right = node2;
        node2.left = node3;
        node2.left = node4;
        BinaryTreeCameras binaryTreeCameras = new BinaryTreeCameras();
        int minCamera = binaryTreeCameras.stat(node1);
        System.out.println(minCamera);
    }

}
