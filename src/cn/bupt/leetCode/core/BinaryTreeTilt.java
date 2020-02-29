package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:19 2019/8/26
 */
public class BinaryTreeTilt {

    /**
     * Given a binary tree, return the tilt of the whole tree.

     The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

     The tilt of the whole tree is defined as the sum of all nodes' tilt.

     Example:
     Input:
     1
     /   \
     2     3
     Output: 1
     Explanation:
     Tilt of node 2 : 0
     Tilt of node 3 : 0
     Tilt of node 1 : |2-3| = 1
     Tilt of binary tree : 0 + 0 + 1 = 1
     Note:

     The sum of node values in any subtree won't exceed the range of 32-bit integer.
     All the tilt values won't exceed the range of 32-bit integer.
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        sum(root);
        return sum;
    }
    int sum = 0;
    public int sum(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftTilt = sum(root.left);
        int rightTilt = sum(root.right);
        sum += Math.abs(leftTilt-rightTilt);
        return leftTilt+rightTilt+root.val;
    }

    public static void main(String[] args) {
        BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;

        node2.left = node3;
        node2.right = node4;

        int tilt = binaryTreeTilt.findTilt(node1);
        System.out.println(tilt);
    }

}
