package cn.bupt.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeLeft2Right {

	 public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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
	        	resultList.add(list);
	        }
	        return resultList;
	 }
}
