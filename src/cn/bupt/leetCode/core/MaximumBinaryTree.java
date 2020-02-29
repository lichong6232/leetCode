package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:16 2019/8/26
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        int nums[] = new int[]{3,2,1,6,0,5};
        TreeNode node = maximumBinaryTree.constructMaximumBinaryTree(nums);
        visit(node);
    }



    private TreeNode buildTree(int nums[],int left,int right){
        if (left>right){
            return null;
        }
        int maxIndex = maxIndex(nums,left,right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums,left,maxIndex-1);
        root.right = buildTree(nums,maxIndex+1,right);
        return root;
    }

    private int maxIndex(int nums[],int left,int right){
        int maxIndex = left;
        for (int i=left+1;i<=right;i++){
            if (nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    private static void visit(TreeNode node){
        if (node==null){
            return;
        }
        System.out.println(node.val);
        visit(node.left);
        visit(node.right);
    }

}
