package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:20 2019/9/11
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode pre= dummpy,curr = head;
        while (curr!=null && curr.next!=null){
            if ((curr.val == curr.next.val)){
                ListNode temp = curr;
                while (curr!=null && temp.val == curr.val){
                    curr = curr.next;
                }
                pre.next = curr;
            }else {
                pre = curr;
                curr = curr.next;

            }
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 removeDuplicatesFromSortedList2 = new RemoveDuplicatesFromSortedList2();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode node = removeDuplicatesFromSortedList2.deleteDuplicates(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
