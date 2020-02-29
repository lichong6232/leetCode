package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:48 2019/9/14
 */
public class SortList {


    public ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummpy = new ListNode(-1);
        ListNode curr = head.next;
        head.next = null;
        dummpy.next = head;
        while (curr!=null){
            ListNode next = curr.next;
            ListNode pre = dummpy;
            while (pre.next!=null && pre.next.val<= curr.val){
                pre = pre.next;
            }
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return dummpy.next;
    }

    public ListNode mergeSortList(ListNode head){
        if (head== null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(mergeSortList(head),mergeSortList(next));
    }

    private ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null &&  fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummpy = new ListNode(-1);
        ListNode curr = dummpy;
        while (left!=null && right!=null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            }else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left!=null){
            curr.next = left;
        }
        if (right!=null){
            curr.next = right;
        }
        return dummpy.next;
    }

    public ListNode sort(ListNode head){
        return quickSort(head,null);
    }

    private ListNode quickSort(ListNode left,ListNode right){
        if(left!=right){
            ListNode partition=partition(left, right);
            quickSort(left, partition);
            quickSort(partition.next, right);
        }
        return left;
    }

    private void swap(ListNode p,ListNode q){
        if(p!=q){
            int temp=p.val;
            p.val=q.val;
            q.val=temp;
        }
    }


    private ListNode partition(ListNode left,ListNode right){
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



    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode node = sortList.insertSortList(node1);
        ListNode node = sortList.mergeSortList(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
