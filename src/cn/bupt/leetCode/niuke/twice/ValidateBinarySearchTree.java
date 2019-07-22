package cn.bupt.leetCode.niuke.twice;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:26 2019/6/1
 */
public class ValidateBinarySearchTree {


    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.

     confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.


     OJ's Binary Tree Serialization:
     The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

     Here's an example:

     1
     / \
     2   3
     /
     4
     \
     5
     The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root,pre = null;
        while (node != null){
            stack.add(node);
            node = node.left;
            while (node == null && !stack.isEmpty()){
                TreeNode temp = stack.pop();
                if (pre != null && pre.val>=temp.val){
                    return false;
                }
                pre = temp;
                node = temp.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }


}
