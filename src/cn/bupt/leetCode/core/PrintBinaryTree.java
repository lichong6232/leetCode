package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:10 2019/8/26
 */
public class PrintBinaryTree {

    /**
     *Print a binary tree in an m*n 2D string array following these rules:

     The row number m should be equal to the height of the given binary tree.
     The column number n should always be an odd number.
     The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
     Each unused space should contain an empty string "".
     Print the subtrees following the same rules.
     Example 1:
     Input:
     1
     /
     2
     Output:
     [["", "1", ""],
     ["2", "", ""]]
     Example 2:
     Input:
     1
     / \
     2   3
     \
     4
     Output:
     [["", "", "", "1", "", "", ""],
     ["", "2", "", "", "", "3", ""],
     ["", "", "4", "", "", "", ""]]
     Example 3:
     Input:
     1
     / \
     2   5
     /
     3
     /
     4
     Output:

     [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
     ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
     ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
     ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int size = (int) Math.pow(2,height)-1;
        List<List<String>> result = new ArrayList<>();
        for (int i=0;i<height;i++){
            String strs[] = new String[size];
            Arrays.fill(strs,"");
            List<String> list = Arrays.asList(strs);
            result.add(list);
        }
        recursion(result,root,0,size-1,0);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node1.right = node5;
        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        List<List<String>> lists = printBinaryTree.printTree(node1);
        System.out.println(lists);
    }

    private void recursion(List<List<String>> result, TreeNode node, int left, int right,int level){
        if (node==null){
            return;
        }
        int mid = (left+right)/2;
        List<String> list = result.get(level);
        list.set(mid,String.valueOf(node.val));
        recursion(result,node.left,left,mid-1,level+1);
        recursion(result,node.right,mid+1,right,level+1);
    }

    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right)) +1;
    }
}
