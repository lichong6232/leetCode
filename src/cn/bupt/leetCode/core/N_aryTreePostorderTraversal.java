package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:13 2019/9/8
 */
public class N_aryTreePostorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root,list);
        return list;
    }

    private void postOrder(Node root,List<Integer> list){
        if (root == null){
            return;
        }
        for (Node node : root.children){
            postOrder(node,list);
        }
        list.add(root.val);
    }


}
