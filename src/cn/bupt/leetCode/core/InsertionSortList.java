package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:09 2019/9/9
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        if (head==null){
            return null;
        }
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode curr = head.next;
        head.next = null;
        while (curr!=null){
            ListNode pre = dummpy;
            while (pre.next!=null && pre.next.val<curr.val){
                pre = pre.next;
            }
            ListNode next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = insertionSortList.insertionSortList(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
