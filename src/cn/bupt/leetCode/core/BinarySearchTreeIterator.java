package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:12 2019/8/8
 */
public class BinarySearchTreeIterator {


    TreeNode curr;
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new Stack<>();
        curr = root;
    }

    /** @return the next smallest number */
    public int next() {
        while (curr!=null){
            stack.add(curr);
            curr = curr.left;
        }
        TreeNode pop = stack.pop();
        curr = pop.right;
        return pop.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr!=null || !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(node1);
        System.out.println(iterator.next());    // return 3
        System.out.println(iterator.next());    // return 7
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 9
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 15
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 20
        System.out.println(iterator.hasNext()); // return false

    }


}
