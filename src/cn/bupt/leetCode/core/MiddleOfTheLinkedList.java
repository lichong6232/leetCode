package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:24 2019/9/14
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
