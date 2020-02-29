package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:10 2019/9/9
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                break;
            }
        }
        if (fast == null || fast.next == null){
            return null;
        }
        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
