package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:41 2019/9/8
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public static void main(String[] args) {
        TreeNode s_node3 = new TreeNode(3);
        TreeNode s_node4 = new TreeNode(4);
        TreeNode s_node5 = new TreeNode(5);
        TreeNode s_node1 = new TreeNode(1);
        TreeNode s_node2 = new TreeNode(2);
        s_node3.left = s_node4;
        s_node3.right = s_node5;
        s_node4.left = s_node1;
        s_node4.right = s_node2;
        TreeNode t_node4 = new TreeNode(4);
        TreeNode t_node1 = new TreeNode(1);
        TreeNode t_node2 = new TreeNode(2);
        t_node4.left = t_node1;
        t_node4.right = t_node2;
        /*TreeNode s_node1 = new TreeNode(1);
        TreeNode s_node2 = new TreeNode(1);
        s_node1.left = s_node2;
        TreeNode t_node1 = new TreeNode(1);*/
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        boolean subtree = subtreeOfAnotherTree.isSubtree(s_node3, t_node4);
        System.out.println(subtree);

    }

    private boolean equals(TreeNode s,TreeNode t){
        if (s == null && t==null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        return (s.val == t.val) && equals(s.left,t.left) && equals(s.right,t.right);
    }

    private boolean traverse(TreeNode s,TreeNode t){
        return s!=null &&(equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }
}
