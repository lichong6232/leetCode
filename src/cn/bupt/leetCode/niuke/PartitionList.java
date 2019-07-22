package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:09 2019/1/29
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode slow = tmpHead;

        ListNode fast = tmpHead;
        while (fast!=null && fast.next!=null){
            if (fast.next.val<x){
                if (slow == fast){
                    slow = slow.next;
                    fast = fast.next;
                }else {
                    ListNode tmpNext = fast.next;
                    fast.next = tmpNext.next;
                    tmpNext.next = slow.next;
                    slow.next = tmpNext;
                    slow = tmpNext;
                }
                continue;
            }
            fast = fast.next;
        }
        return tmpHead.next;

    }

}
