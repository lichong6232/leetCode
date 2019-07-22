package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:25 2019/5/31
 */
public class BinaryTreeMaximumPathSum {

    /**
     * Given a binary tree, find the maximum path sum.

     The path may start and end at any node in the tree.

     For example:
     Given the below binary tree,

     1
     / \
     2   3

     Return6.
     * @param root
     * @return
     */
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int sum = root.val;
        int leftChildSum = maxPath(root.left);
        int rightChildSum = maxPath(root.right);
        if (leftChildSum>0){
            sum+=leftChildSum;
        }
        if (rightChildSum>0){
            sum+=rightChildSum;
        }
        if (sum>max){
            max = sum;
        }
        return Math.max(leftChildSum,rightChildSum)>0?Math.max(leftChildSum,rightChildSum)+root.val:root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        int maxPathSum = binaryTreeMaximumPathSum.maxPathSum(root);
        System.out.println(maxPathSum);
    }


}
