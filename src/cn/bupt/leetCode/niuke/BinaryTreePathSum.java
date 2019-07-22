package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left=node2;
		node1.right=node3;
		BinaryTreePathSum binaryTreePathSum = new BinaryTreePathSum();
		System.out.println(binaryTreePathSum.sumNumbers(node1));
		
		
	}
	
	private StringBuffer path =new StringBuffer();
	private List<StringBuffer> pathList = new ArrayList<StringBuffer>();
	public int sumNumbers(TreeNode root) {
        findPath(root);
        int sum =0;
        for(StringBuffer tempPath:pathList){
        	sum+=Integer.parseInt(tempPath.toString());
        }
		return sum;
    }
	
	public void findPath(TreeNode treeNode){
		if(treeNode == null)
			return;
		path.append(treeNode.val);
		if(treeNode.left == null && treeNode.right == null){
			pathList.add(new StringBuffer(path));
		}
		findPath(treeNode.left);
		findPath(treeNode.right);
		path.deleteCharAt(path.length()-1);
		
	}

}
