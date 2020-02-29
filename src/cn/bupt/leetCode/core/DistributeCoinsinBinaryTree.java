package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:51 2019/8/26
 */
public class DistributeCoinsinBinaryTree {


    public int distributeCoins(TreeNode root) {
        getStep(root);
        return step;
    }
    int step=0;
    private int getStep(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftStep = getStep(root.left);
        int rightStep = getStep(root.right);
        step += Math.abs(leftStep) + Math.abs(rightStep);
        return leftStep + rightStep + root.val -1;
    }
}
