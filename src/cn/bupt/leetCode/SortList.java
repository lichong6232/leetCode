package cn.bupt.leetCode;


/*
 * 题目要求时间复杂度为o(nlogn)，则可以用归并或者快速排序且空间复杂度为常数
 */

public class SortList {
	
	public static void main(String[] args) {
		ListNode listNode1=new ListNode(9);
		ListNode listNode2=new ListNode(8);
		ListNode listNode3=new ListNode(1);
		ListNode listNode4=new ListNode(3);
		ListNode listNode5=new ListNode(2);
		ListNode listNode6=new ListNode(5);
		ListNode listNode7=new ListNode(4);
		ListNode listNode8=new ListNode(9);
		ListNode listNode9=new ListNode(3);
		ListNode listNode10=new ListNode(7);
		ListNode listNode11=new ListNode(2);
		ListNode listNode12=new ListNode(6);
		ListNode listNode13=new ListNode(5);
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=listNode5;
		listNode5.next=listNode6;
		listNode6.next=listNode7;
		listNode7.next=listNode8;
		listNode8.next=listNode9;
		listNode9.next=listNode10;
		listNode10.next=listNode11;
		listNode11.next=listNode12;
		listNode12.next=listNode13;
		SortList sortList=new SortList();
		ListNode sortNode=sortList.insertSort(listNode1);
		sortList.outPut(sortNode);
		
		
		
	}
	
	public void outPut(ListNode listNode){
		ListNode curr=listNode;
		while(curr!=null){
			System.out.println(curr.val);
			curr=curr.next;
		}
	}
	
	//方法1，归并排序法
	public ListNode sortList(ListNode head) {
		
		if(head==null||head.next==null)
			return head;
		ListNode mid=getMidNode(head);
		ListNode right=mid.next;
		mid.next=null;
		return merge(sortList(head), sortList(right));
    }
	
	public ListNode merge(ListNode left,ListNode right){
		ListNode root=new ListNode(0);
		ListNode curr=root;
		while(left!=null&&right!=null){
			if(left.val<=right.val){
				curr.next=left;
				left=left.next;
			}else{
				curr.next=right;
				right=right.next;
			}
			curr=curr.next;
		}
		
		if(left!=null){
			curr.next=left;
		}else{
			curr.next=right;
		}
		return root.next;
	}
	
	public ListNode getMidNode(ListNode head){
		ListNode fast=head;
		ListNode slow=head;
		while(fast.next!=null&&fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		
		return slow;
	}
	
	//快速排序
	public ListNode sortList1(ListNode listNode){
		
		if(listNode==null || listNode.next==null)
			return listNode;
		return quickSort(listNode, null);
		
	}
	
	public void swap(ListNode node1,ListNode node2){
		if(node1!=node2){
			int temp=node1.val;
			node1.val=node2.val;
			node2.val=temp;
		}
	}
	
	public ListNode quickSort(ListNode node1,ListNode node2){
		if(node1!=node2){
			ListNode curr=partition(node1, node2);
			quickSort(node1, curr);
			quickSort(curr.next, node2);
		}
		return node1;
	}
	
	public ListNode partition(ListNode left,ListNode right){
		ListNode p=left,q=left.next;
		int key=left.val;
		while(q!=right){
			if(q.val<key){
				p=p.next;
				swap(p, q);
			}
			q=q.next;
		}
		swap(left, p);
		return p;
	}
	//插入排序
	public ListNode insertSort(ListNode head){
		ListNode root=new ListNode(Integer.MIN_VALUE);
		ListNode curr=head;
		while(curr!=null){
			ListNode temp=root;
			ListNode next=curr.next;
			while(temp.next!=null&&temp.next.val<curr.val){
				temp=temp.next;
			}
			curr.next=temp.next;
			temp.next=curr;
			curr=next;
		}
		return root.next;
	}

}
