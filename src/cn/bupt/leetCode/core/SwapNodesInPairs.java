package cn.bupt.leetCode.core;

import cn.bupt.leetCode.niuke.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:20 2019/7/5
 */
public class SwapNodesInPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.

     You may not modify the values in the list's nodes, only nodes itself may be changed.

     Example:

     Given 1->2->3->4, you should return the list as 2->1->4->3.
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode curr = head,pre= dummpy;
        while (curr!=null && curr.next!=null){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            pre = curr;
            curr = curr.next;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = swapNodesInPairs.swapPairs(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
