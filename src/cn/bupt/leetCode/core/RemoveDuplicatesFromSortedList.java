package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:16 2019/9/12
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr!=null && curr.next!=null){
            ListNode temp = curr;
            while (curr!=null && temp.val == curr.val){
                curr = curr.next;
            }
            temp.next = curr;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = removeDuplicatesFromSortedList.deleteDuplicates(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
