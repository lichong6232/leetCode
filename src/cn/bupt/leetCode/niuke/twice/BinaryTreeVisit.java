package cn.bupt.leetCode.niuke.twice;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:32 2019/6/1
 */
public class BinaryTreeVisit {

    public static void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null){
            System.out.println(node.val);
            stack.add(node);
            node = node.left;
            while (node == null && !stack.isEmpty()){
                node = stack.pop().right;
            }
        }
    }

    public static void inOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null){
            stack.add(node);
            node = node.left;
            while (node == null && !stack.isEmpty()){
                TreeNode mid = stack.pop();
                System.out.println(mid.val);
                node = mid.right;
            }
        }
    }

    public static void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode pre = null;
        while (!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if ((temp.left == null && temp.right == null) || (pre != null && (temp.left == pre || temp.right == pre))){
                stack.pop();
                System.out.println(temp.val);
                pre = temp;
            }else {
                if (temp.right!=null){
                    stack.add(temp.right);
                }
                if (temp.left != null){
                    stack.add(temp.left);
                }
            }
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node4.right = node5;
//        preOrder(node1);
//        inOrder(node1);
        postOrder(node1);
    }
}
