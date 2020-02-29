package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:33 2019/10/27
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummpy = new ListNode(-1);
        ListNode curr1 = l1,curr2 = l2,curr = dummpy;
        while (curr1!=null && curr2!=null){
            int value = curr1.val+curr2.val+carry;
            carry = value/10;
            ListNode node = new ListNode(value%10);
            curr.next = node;
            curr = node;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1!=null){
            int value = carry+curr1.val;
            carry = value/10;
            curr1.val = carry%10;
            curr.next = curr1;
            curr = curr1;
            curr1 = curr1.next;
        }

        while (curr2!=null){
            int value = carry+curr2.val;
            carry = value/10;
            curr2.val = carry%10;
            curr.next = curr2;
            curr = curr2;
            curr2 = curr2.next;
        }
        if (carry>0){
            curr.next = new ListNode(carry);
        }
        return dummpy.next;


    }
}
