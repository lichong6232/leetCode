package cn.bupt.leetCode.niuke.twice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:10 2019/6/1
 */
public class PopulatingNextRightPointersInEachNode {


    /**
     * Given a binary tree

     struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
     }

     Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.

     Initially, all next pointers are set toNULL.

     Note:

     You may only use constant extra space.
     You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

     For example,
     Given the following perfect binary tree,

     1
     /  \
     2    3
     / \  / \
     4  5  6  7

     After calling your function, the tree should look like:

     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \  / \
     4->5->6->7 -> NULL
     * @param root
     */
    public void connect(TreeLinkNode root) {

        if (root == null){
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        TreeLinkNode temp = new TreeLinkNode(-1);
        TreeLinkNode curr = temp;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeLinkNode node = queue.poll();
                curr.next = node;
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                curr = node;
            }
            curr = temp;
        }

    }

    public void connect1(TreeLinkNode root) {
        TreeLinkNode node = root;
        TreeLinkNode layerFirstNode = new TreeLinkNode(-1);
        while (node!=null){

            TreeLinkNode curr = layerFirstNode;

            while (node!=null){
                if (node.left!=null){
                    curr.next = node.left;
                    curr = node.left;
                }
                if (node.right!=null){
                    curr.next = node.right;
                    curr = node.right;
                }
                node = node.next;
            }
            node = layerFirstNode.next;
            layerFirstNode.next = null;
        }
    }

    public static void main(String[] args) {

        /*TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode = new PopulatingNextRightPointersInEachNode();
        populatingNextRightPointersInEachNode.connect(node1);*/


    }




    static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
