package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:02 2019/9/9
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
