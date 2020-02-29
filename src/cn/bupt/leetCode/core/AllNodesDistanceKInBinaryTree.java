package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:37 2019/10/26
 */
public class AllNodesDistanceKInBinaryTree {


    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        distince(root,target,K);
        return ans;
    }

    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree allNodesDistanceKInBinaryTree = new AllNodesDistanceKInBinaryTree();
        /*TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);

        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;*/
        /*TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;*/

        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        node1.left = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;


        List<Integer> list = allNodesDistanceKInBinaryTree.distanceK(node1, node3, 2);
        System.out.println(list);

    }

    private int distince(TreeNode root, TreeNode target,int k){
        if (root==null){
            return -1;
        }
        if (root == target){
            addNode(root,0,k);
            return 0;
        }else {
            int left = distince(root.left,target,k);
            int right = distince(root.right,target,k);
            if (left!=-1){

                if (left == k-1){
                    ans.add(root.val);
                }
                else {
                    addNode(root.right,left+2,k);
                }
                return left+1;
            }
            if (right!=-1){
                if (right == k-1){
                    ans.add(root.val);
                }
                else {
                    addNode(root.left,right+2,k);
                }
                return right+1;
            }

        }
        return -1;
    }

    private void addNode(TreeNode node,int distince,int k){
        if (node==null){
            return;
        }
        if (distince == k){
            ans.add(node.val);
        }else {
            addNode(node.left,distince+1,k);
            addNode(node.right,distince+1,k);
        }
    }
}
