package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 上午9:17 2019/6/2
 */
public class UniqueBinarySearchTrees2 {

    /**
     * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

     For example,
     Given n = 3, your program should return all 5 unique BST's shown below.

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3

     confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.


     OJ's Binary Tree Serialization:
     The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

     Here's an example:

     1
     / \
     2   3
     /
     4
     \
     5
     The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
     * @param n
     * @return
     */
    public ArrayList<TreeNode> generateTrees(int n) {
        return buildTree(1,n);
    }

    private ArrayList<TreeNode> buildTree(int low, int high){
        ArrayList<TreeNode> nodes = new ArrayList<>();
        if (low>high){
            nodes.add(null);
            return nodes;
        }
        for (int i=low;i<=high;i++){
            ArrayList<TreeNode> leftChilds = buildTree(low,i-1);
            ArrayList<TreeNode> rightChilds = buildTree(i+1,high);
            for (TreeNode leftChild : leftChilds){
                for (TreeNode rightChild : rightChilds){
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }
}
