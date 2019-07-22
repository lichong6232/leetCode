package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:41 2019/6/1
 */
public class PathSum2 {


    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

     For example:
     Given the below binary tree andsum = 22,
     5
     / \
     4   8
     /   / \
     11  13  4
     /  \    / \
     7    2  5   1
     return

     [
     [5,4,11,2],
     [5,8,4,5]
     ]
     * @param root
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(result,new ArrayList<>(),root,sum);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5_1 = new TreeNode(5);
        node5.left = node4;
        node5.right = node8;
        node4.left  = node11;
        node8.left = node13;
        node8.right = node4_1;
        node11.left = node7;
        node11.right = node2;
        node4_1.left = node5_1;
        node4_1.right = node1;
        PathSum2 pathSum2 = new PathSum2();
        ArrayList<ArrayList<Integer>> result = pathSum2.pathSum(node5, 22);
        System.out.println(result);
    }

    private void dfs(ArrayList<ArrayList<Integer>> result ,ArrayList<Integer> temp, TreeNode node,int sum){
        if (node == null){
            return;
        }
        temp.add(node.val);
        if (node.left == null && node.right == null && sum == node.val){
            result.add(new ArrayList<>(temp));
        }

        dfs(result,temp,node.left,sum - node.val);
        dfs(result,temp,node.right,sum-node.val);
        temp.remove(temp.size()-1);
    }

}
