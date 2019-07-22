package cn.bupt.leetCode.niuke;

public class ReorderList {
	
	public static void main(String[] args) {
		ListNode node0=new ListNode(0);
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		node0.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		ReorderList reorderList=new ReorderList();
		reorderList.outPut(node0);
//		ListNode reverseNode=reorderList.reverse(node0);
//		reorderList.outPut(reverseNode);
		reorderList.reorderList(node0);
		System.out.println("�����");
		reorderList.outPut(node0);
	}
	
	 public void reorderList(ListNode head) {
		 if(head==null)
			 return ;
		 
	        ListNode mid=getMidNode(head);
	        ListNode right=reverse(mid.next);
	        mid.next=null;
	        ListNode left=head;
	        while(right!=null){
	        	ListNode nextLeft=left.next;
	        	ListNode nextRight=right.next;
	        	right.next=left.next;
	        	left.next=right;
	        	
	        	left=nextLeft;
	        	right=nextRight;
	        }
	        
	 }
	 
	 public void outPut(ListNode node){
		 ListNode curr=node;
		 while(curr!=null){
			 System.out.println(curr.val);
			 curr=curr.next;
		 }
	 }
	 
	 public ListNode reverse(ListNode head){
		 ListNode pre=null;
		 ListNode curr=head;
		 while(curr!=null){
			 ListNode  temp=curr.next;
			 curr.next=pre;
			 pre=curr;
			 curr=temp;
		 }
		 return pre;
	 }
	 
	 
	 public ListNode getMidNode(ListNode node){
		 if(node==null)
			 return null;
		 
		 ListNode slow=node,fast=node;
		 while(fast.next!=null&&fast.next.next!=null){
			 fast=fast.next.next;
			 slow=slow.next;
		 }
		 return slow;
	 }

}
