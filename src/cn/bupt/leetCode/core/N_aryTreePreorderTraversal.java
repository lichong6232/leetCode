package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:09 2019/9/8
 */
public class N_aryTreePreorderTraversal {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return list;
    }

    public static void main(String[] args) {

    }

    private void preOrder(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        for (Node node: root.children){
            preOrder(node,list);
        }

    }
}
