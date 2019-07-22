package cn.bupt.leetCode.niuke;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:56 2019/1/23
 */
public class AllBST {

    /**
     * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

     For example,
     Given n = 3, your program should return all 5 unique BST's shown below.

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
     * @param n
     * @return
     */
    public static ArrayList<TreeNode> generateTrees(int n) {
        return buildTree(1,n);
    }

    public static ArrayList<TreeNode> buildTree(int low, int high){
        ArrayList<TreeNode> treeNodes = new ArrayList();
        if (low>high){
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = low;i<=high;i++){
            ArrayList<TreeNode> leftChilds = buildTree(low,i-1);
            ArrayList<TreeNode> rightChilds = buildTree(i+1,high);
            for (int j=0;j<leftChilds.size();j++){
                for (int k=0;k<rightChilds.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftChilds.get(j);
                    root.right = rightChilds.get(k);
                    treeNodes.add(root);
                }
            }
        }
        return treeNodes;
    }



    public static void  buildTreeNode(TreeNode root,int data){
        TreeNode parentNode=root,current = root;
        boolean isLeft = false;
        while (current!=null){
            parentNode = current;
            if (data<current.val){
                current = current.left;
                isLeft = true;
            }else {
                current = current.right;
            }
        }
        TreeNode treeNode = new TreeNode(data);
        if (isLeft){
            parentNode.left = treeNode;
        }else {
            parentNode.right = treeNode;
        }

    }

    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        for (int i=1;i<=3;i++){
            list.add(i);
        }

        List<List<Integer>> lists = allSort(list);
        System.out.println(lists);*/
        ArrayList<TreeNode> treeNodes = generateTrees(2);
        System.out.println(treeNodes);
        for (TreeNode node : treeNodes){
            String visitSequence = visit(node);
            System.out.println(visitSequence);
        }
    }

    public static String visit(TreeNode root){

        if (root == null){
            return null;
        }

        StringBuilder visitSequence = new StringBuilder();

        Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){

            TreeNode node = queue.poll();
            if (node.val==-1){
                visitSequence.append("#");
                visitSequence.append(",");
            }else {
                visitSequence.append(node.val);
                visitSequence.append(",");
            }

            TreeNode node1 = new TreeNode(-1);
            if (node.left == null && node.right == null){
                continue;
            }
            if (node.left!=null){
                queue.add(node.left);
            }else {
                queue.add(node1);
            }
            if (node.right!=null){
                queue.add(node.right);
            }else {
                queue.add(node1);
            }

        }
        return visitSequence.deleteCharAt(visitSequence.length()-1).toString();


    }


    public static List<List<Integer>> allSort(List<Integer>list){
        List<List<Integer>> result = new ArrayList<>();
        if (list.size() == 1){
            List<Integer> temp = new ArrayList<>();
            temp.add(list.get(0));
            result.add(temp);
            return result;
        }

        for (int i=0;i<list.size();i++){
            Integer removed = list.remove(i);
            allSort(list)
                    .stream()
                    .forEach(childList->{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(removed);
                        temp.addAll(childList);
                        result.add(temp);
                    });
            list.add(i,removed);
        }
        return result;

    }
}
