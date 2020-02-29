package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;
import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:25 2019/9/1
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        return buildBinarySearchTree(head,null);

    }

    private TreeNode buildBinarySearchTree(ListNode left, ListNode right){
        if (left == right){
            return null;
        }
        ListNode mid = mid(left, right);
        TreeNode leftNode = buildBinarySearchTree(left, mid);
        TreeNode rightNode = buildBinarySearchTree(mid.next, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    private ListNode mid(ListNode left, ListNode right){
        ListNode fast=left,slow = left;
        while (fast!=right && fast.next!=right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
        TreeNode node = convertSortedListToBinarySearchTree.sortedListToBST(node1);
        visit(node);
    }

    private static void visit(TreeNode head){
        if (head!=null){
            System.out.println(head.val);
            visit(head.left);
            visit(head.right);
        }
    }
}
