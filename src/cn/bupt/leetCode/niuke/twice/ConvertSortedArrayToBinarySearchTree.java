package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:40 2019/6/1
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST
     * @param num
     * @return
     */
    public TreeNode sortedArrayToBST(int[] num) {
        return buildTree(num,0,num.length-1);
    }

    private TreeNode buildTree(int num[],int left,int right){
        if (left>right){
            return null;
        }
        int mid = (left+right)/2 + (left+right)%2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildTree(num,left,mid-1);
        root.right = buildTree(num,mid+1,right);
        return root;
    }

}
