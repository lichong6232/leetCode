package cn.bupt.leetCode.niuke;

public class SortedListToBST {

	public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
        	return null;
        if(head.next==null)
        	return new TreeNode(head.val);
        ListNode mid=head,end=head,preMid=null;
        while(end!=null&&end.next!=null){
        	preMid=mid;
        	mid=mid.next;
        	end=end.next.next;
        }
        preMid.next=null;
        TreeNode root=new TreeNode(mid.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return root;
        
    }
}
