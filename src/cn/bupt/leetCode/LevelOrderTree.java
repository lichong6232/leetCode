package cn.bupt.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTree {
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		root.left=node1;
		root.right=node3;
		LevelOrderTree levelOrderTree=new LevelOrderTree();
		System.out.println(levelOrderTree.levelOrderBottom(root));
	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> resultList=new ArrayList<ArrayList<Integer>>();
        if(root==null)
        	return resultList;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int size=queue.size();
        	ArrayList<Integer> list=new ArrayList<Integer>();
        	for(int i=0;i<size;i++){
        		TreeNode node=queue.poll();
        		list.add(node.val);
        		if(node.left!=null){
        			queue.add(node.left);
        		}
        		if(node.right!=null){
        			queue.add(node.right);
        		}
        	
        	}
        	resultList.add(0, list);
        }
        return resultList;
    }
	
}
