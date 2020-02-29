package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:58 2019/9/7
 */
public class FindModeInBinarySearchTree {

    public int[] findMode(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int currentCount=1,preCount=0;
        TreeNode pre = null;
        while (curr!=null){
            stack.add(curr);
            curr = curr.left;
            while (curr == null && !stack.isEmpty()){
                TreeNode pop = stack.pop();
                if (pre != null && pre.val == pop.val){
                    currentCount++;
                }else {
                    currentCount = 1;
                }
                if (currentCount>preCount){
                    list.clear();
                    list.add(pop.val);
                    preCount = currentCount;
                }else if (currentCount == preCount){
                    list.add(pop.val);
                }
                pre = pop;
                curr = pop.right;
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(2);
        node1.right = node2;
//        node2.left = node3;
        FindModeInBinarySearchTree findModeInBinarySearchTree = new FindModeInBinarySearchTree();
        int[] mode = findModeInBinarySearchTree.findMode(node1);
        System.out.println(Arrays.toString(mode));

    }
}
