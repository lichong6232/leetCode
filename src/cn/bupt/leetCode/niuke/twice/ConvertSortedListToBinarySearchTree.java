package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:12 2019/6/1
 */
public class ConvertSortedListToBinarySearchTree {

    /**
     * 问题描述：
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head,null);
    }

    private TreeNode buildBST(ListNode left, ListNode right){
        if (left == right){
            return null;
        }
        ListNode fast = left,slow = left;
        while (fast!=right && fast.next!=right){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(left,slow);
        root.right = buildBST(slow.next,right);
        return root;
    }


}
