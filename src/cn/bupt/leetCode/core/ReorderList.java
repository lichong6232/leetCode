package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:38 2019/9/11
 */
public class ReorderList {


    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode reverse = reverse(next);
        ListNode curr1 = head;
        ListNode curr2 = reverse;
        while (curr1!=null && curr2!=null){
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr2.next = next1;
            curr1.next = curr2;
            curr1 = next1;
            curr2 = next2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(node1);

        ListNode curr = node1;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }

    }

    private ListNode reverse(ListNode head){
        ListNode per = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = per;
            per = curr;
            curr = next;
        }
        return per;
    }

    private ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
