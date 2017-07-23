package cn.bupt.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintZList {
	
	public static void main(String[] args) {
		PrintZList printZList=new PrintZList();
		TreeNode root=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		TreeNode node3=new TreeNode(4);
		TreeNode node4=new TreeNode(5);
		root.left=node1;
		root.right=node2;
		node1.left=node3;
		node1.right=node4;
		System.out.println(printZList.zigzagLevelOrder(root));
		
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> resultList=new ArrayList<ArrayList<Integer>>();
		if(root==null)
			return resultList;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		int k=0;
		while(!queue.isEmpty()){
			ArrayList<Integer> list=new ArrayList<Integer>();
			int size=queue.size();
			for(int i=0;i<size;i++){
				TreeNode node=queue.poll();
				int val=node.val;
				if(k==0){
					list.add(val);
				}else{
					list.add(0, val);
				}
				if(node.left!=null){
					queue.add(node.left);
				}
				if(node.right!=null){
					queue.add(node.right);
				}
			}
			resultList.add(list);
			k=k==0?1:0;
		}
		
		return resultList;
    }
}
