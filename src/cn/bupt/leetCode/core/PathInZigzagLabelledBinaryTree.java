package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:26 2019/8/27
 */
public class PathInZigzagLabelledBinaryTree {

    /**
     * In an infinite binary tree where every node has two children, the nodes are labelled in row order.

     In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.



     Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.



     Example 1:

     Input: label = 14
     Output: [1,3,4,14]
     Example 2:

     Input: label = 26
     Output: [1,2,6,10,26]

     解题思路：在label所在的层中，将label所在的层进行翻转，求出label翻转后的位置的值，将label翻转后的值除以2，就是
     label的父节点的值，依次向上找父节点的值，就找到了所有的从根节点到当前节点的路径

     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> result = new LinkedList<>();
        while (label!=0){
            result.addFirst(label);
            label = getParentLabel(label);
        }
        return result;
    }

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree pathInZigzagLabelledBinaryTree = new PathInZigzagLabelledBinaryTree();
        List<Integer> list = pathInZigzagLabelledBinaryTree.pathInZigZagTree(14);
        System.out.println(list);

    }



    private int getParentLabel(int label){
        int count=0;
        int num = label;
        while (num!=0){
            count++;
            num/=2;
        }
        int start = (int)Math.pow(2,count-1);
        int mid = start+(start>>>1);
        //翻转后的label对应位置的值，比如4，5，6，7。中，如果label为6，则翻转后的值为：5
        int original = 2*mid-label-1;
        return original/2;
    }
}
