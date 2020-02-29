package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:14 2019/9/9
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode dummpy = new ListNode(-1);
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = dummpy.next;
            dummpy.next = curr;
            curr = next;
        }
        return dummpy.next;
    }

    public ListNode reverseList3(ListNode head){
        if (head == null){
            return null;
        }
        ListNode dummpy = new ListNode(-1);
        ListNode curr = head;
        dummpy.next = head;
        while (curr.next!=null){
            ListNode node = curr.next;
            curr.next = node.next;
            node.next = dummpy.next;
            dummpy.next = node;
        }
        return dummpy.next;
    }
}
