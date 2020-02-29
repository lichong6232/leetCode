package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:33 2019/9/5
 */
public class CountCompleteTreeNodes {


    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
//        node3.right = node7;
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        int count = countCompleteTreeNodes.countNodes(node1);
        System.out.println(count);


    }


}
