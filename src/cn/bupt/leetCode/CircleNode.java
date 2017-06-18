package cn.bupt.leetCode;

import java.util.HashSet;
import java.util.Set;

public class CircleNode {
	
	public static void main(String[] args) {
		ListNode node0=new ListNode(0);
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		ListNode node7=new ListNode(7);
		ListNode node8=new ListNode(8);
		node0.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		node7.next=node8;
		node8.next=node3;
		CircleNode circleNode=new CircleNode();
		ListNode circleListNode=circleNode.detectCycle(node0);
		System.out.println(circleListNode.val);
	}
	
	public ListNode detectCycle(ListNode head) {
		if(head==null)
			return null;
		ListNode fast=head,slow=head;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				break;
		}
		
		if(fast==null||fast.next==null)
			return null;		
		fast=head;
		while(fast!=slow){
			fast=fast.next;
			slow=slow.next;
		}
		return fast;
        
    }

}
