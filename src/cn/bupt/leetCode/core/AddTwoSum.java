package cn.bupt.leetCode.core;

import cn.bupt.leetCode.niuke.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:53 2019/6/21
 */
public class AddTwoSum {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     You may assume the two numbers do not contain any leading zero, except the number 0 itself.

     Example:

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     Explanation: 342 + 465 = 807.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(-1);
        ListNode curr1 = l1,curr2 = l2,curr = dumpy;
        int carry = 0;
        while (curr1!=null && curr2!=null){
            int num = curr1.val + curr2.val + carry;
            carry = num/10;
            ListNode node = new ListNode(num%10);
            curr.next = node;
            curr = node;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr1 != null){
            int num = curr1.val + carry;
            carry = num/10;
            curr1.val = num%10;
            curr.next = curr1;
            curr = curr1;
            curr1 = curr1.next;
        }
        while (curr2!=null){
            int num = curr2.val + carry;
            carry = num/10;
            curr2.val = num%10;
            curr.next = curr2;
            curr = curr2;
            curr2 = curr2.next;
        }
        if (carry>0){
            ListNode listNode = new ListNode(carry);
            curr.next = listNode;
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(8);
        ListNode node1_2 = new ListNode(9);
        ListNode node1_3 = new ListNode(9);
//        ListNode node1_4 = new ListNode(6);
        node1_1.next = node1_2;
        node1_2.next = node1_3;
//        node1_3.next = node1_4;

        ListNode node2_1 = new ListNode(2);
        /*ListNode node2_2 = new ListNode(6);
        ListNode node2_3 = new ListNode(4);
        node2_1.next = node2_2;
        node2_2.next = node2_3;*/
        AddTwoSum addTwoSum = new AddTwoSum();
        ListNode node = addTwoSum.addTwoNumbers(node1_1, node2_1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
