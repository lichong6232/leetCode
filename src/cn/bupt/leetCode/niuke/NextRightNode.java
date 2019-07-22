package cn.bupt.leetCode.niuke;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:59 2019/1/24
 */
public class NextRightNode {


    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    /**
     * 层次遍历的方法，不过不满足题目中说的需要常量级空间复杂度
     * @param root
     */
    public void connect1(TreeLinkNode root){
        Queue<TreeLinkNode> treeLinkNodes = new LinkedList<>();
        if (root!=null){
            treeLinkNodes.add(root);
        }

        while (!treeLinkNodes.isEmpty()){
            int size = treeLinkNodes.size();
            for (int i=0;i<size;i++){
                TreeLinkNode linkNode = treeLinkNodes.poll();
                if (i<size-1){
                    linkNode.next = treeLinkNodes.peek();
                }

                if (linkNode.left!=null){
                    treeLinkNodes.add(linkNode.left);
                }
                if (linkNode.right!=null){
                    treeLinkNodes.add(linkNode.right);
                }
            }

        }
    }


    /**
     * 问题描述：
     * Follow up for problem "Populating Next Right Pointers in Each Node".

     What if the given tree could be any binary tree? Would your previous solution still work?

     Note:

     You may only use constant extra space.

     For example,
     Given the following binary tree,

     1
     /  \
     2    3
     / \    \
     4   5    7

     After calling your function, the tree should look like:

     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \    \
     4-> 5 -> 7 -> NULL
     * @param root
     */
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;

        while (node!=null){
            TreeLinkNode layerFirstNode = new TreeLinkNode(-1);
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
        }
    }

    public ArrayList<Integer> test(TreeNode root){
        ArrayList<Integer> result = new ArrayList();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while(node!=null){
            stack.add(node);
            node = node.left;
            while(node==null&&!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                result.add(tmp.val);
                node = tmp.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*TreeLinkNode root = new TreeLinkNode(0);
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right= node4;
        NextRightNode nextRightNode = new NextRightNode();
        nextRightNode.connect(root);
        TreeLinkNode next = node3.next;
        System.out.println(next.val);*/

        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        layerVisite(root);
    }


    public static void layerVisite(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }

    }

}
