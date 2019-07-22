package cn.bupt.leetCode.niuke.twice;


/**
 * @Author: lichong04
 * @Date: Created in 下午6:15 2019/4/30
 */
public class MinimumDepthOfBinaryTree {

    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left!=null && root.right!=null){
            return Math.min(run(root.left),run(root.right))+1;
        }
        if (root.left == null){
            return run(root.right)+1;
        }else {
            return run(root.left)+1;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node2.right = node3;
        node3.left = node4;
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        int depth = minimumDepthOfBinaryTree.run(root);
        System.out.println(depth);
    }

}
