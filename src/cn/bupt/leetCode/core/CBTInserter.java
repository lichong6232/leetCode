package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:05 2019/9/8
 */
public class CBTInserter {


    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();
    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);
        while (!tempQueue.isEmpty()){
            TreeNode poll = tempQueue.poll();
            if (poll.left == null || poll.right == null){
                queue.add(poll);
            }
            if (poll.left!=null){
                tempQueue.add(poll.left);
            }
            if (poll.right!=null){
                tempQueue.add(poll.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode peek = queue.peek();
        TreeNode node = new TreeNode(v);
        if (peek.left==null){
            peek.left = node;
        }else {
            peek.right = node;
            queue.poll();
        }
        queue.add(node);
        return peek.val;
    }

    public TreeNode get_root() {
        return this.root;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        CBTInserter cbtInserter = new CBTInserter(treeNode1);
        cbtInserter.insert(2);
        cbtInserter.insert(3);
        cbtInserter.insert(4);
//        cbtInserter.insert(2);
        System.out.println(cbtInserter.get_root());

    }

}
