package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:13 2019/10/16
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.right == null && root.left == null && sum==0){
            return true;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum-root.val);

    }
}

