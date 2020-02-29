package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:10 2019/8/7
 */
public class BinaryTreeRightSideView {

    /**
     * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

     Example:

     Input: [1,2,3,null,5,null,4]
     Output: [1, 3, 4]
     Explanation:

     1            <---
     /   \
     2     3         <---
     \     \
     5     4       <---

     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            result.add(queue.peek().val);
            int i=1;
            while (i<=size){
                TreeNode node = queue.poll();
                if (node.right!=null){
                    queue.add(node.right);
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
//        node3.right = node4;
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        List<Integer> list = binaryTreeRightSideView.rightSideView(node1);
        System.out.println(list);

    }

}
