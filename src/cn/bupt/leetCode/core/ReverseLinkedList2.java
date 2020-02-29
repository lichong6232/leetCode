package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:16 2019/9/9
 */
public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode curr = head,pre = dummpy;
        for (int i =1;i<m;i++){
            pre = pre.next;
            curr = curr.next;
        }

        for (int i=0;i<n-m && curr.next!=null;i++){
            ListNode node = curr.next;
            curr.next = node.next;
            node.next = pre.next;
            pre.next = node;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseLinkedList2.reverseBetween(node1, 2, 4);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
