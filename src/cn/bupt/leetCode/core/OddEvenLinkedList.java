package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:11 2019/9/9
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr!= null && curr.next!=null){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            curr = curr.next;
            pre = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        ListNode node = oddEvenLinkedList.oddEvenList(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
