package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:20 2019/10/16
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,new ArrayList<>(),root,sum);
        return result;
    }

    private void dfs(List<List<Integer>> list,List<Integer> temp,TreeNode root,int sum){
        if (root == null){
            return;
        }
        if (root.left==null && root.right == null && sum == root.val){
            List<Integer> newList = new ArrayList<>(temp);
            newList.add(root.val);
            list.add(newList);

        }else {
            temp.add(root.val);
            dfs(list,temp,root.left,sum - root.val);
            dfs(list,temp,root.right,sum - root.val);
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String[] args) {
        PathSum2 pathSum2 = new PathSum2();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        List<List<Integer>> lists = pathSum2.pathSum(root, 22);
        System.out.println(lists);

    }
}
