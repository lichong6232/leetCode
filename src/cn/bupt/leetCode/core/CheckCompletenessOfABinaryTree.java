package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:45 2019/9/7
 */
public class CheckCompletenessOfABinaryTree {


    class Node{
        TreeNode treeNode;
        int code;

        public Node(TreeNode treeNode,int code){
            this.treeNode = treeNode;
            this.code = code;
        }

        public TreeNode getTreeNode() {
            return treeNode;
        }

        public int getCode() {
            return code;
        }

    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null){
            return false;
        }
        List<Node> nodes = new ArrayList<>();
        Node node = new Node(root,1);
        nodes.add(node);
        int i=0;
        for (;i<nodes.size();i++){
            Node currentNode = nodes.get(i);
            TreeNode treeNode = currentNode.treeNode;
            int code = currentNode.code;
            if (treeNode.left!=null){
                nodes.add(new Node(treeNode.left,2*code));
                if (nodes.size()!=2*code){
                    return false;
                }
            }
            if (treeNode.right!=null){
                nodes.add(new Node(treeNode.right,2*code+1));
                if (nodes.size()!=2*code+1){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckCompletenessOfABinaryTree checkCompletenessOfABinaryTree = new CheckCompletenessOfABinaryTree();
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        boolean completeTree = checkCompletenessOfABinaryTree.isCompleteTree(node1);
        System.out.println(completeTree);
    }


}
