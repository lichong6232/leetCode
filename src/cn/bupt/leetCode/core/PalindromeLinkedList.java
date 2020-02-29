package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:19 2019/9/11
 */
public class PalindromeLinkedList {


    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode curr2 = head;
        ListNode curr1 = reverse(right);
        while (curr1!=null){
            if (curr1.val!=curr2.val){
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        boolean palindrome = palindromeLinkedList.isPalindrome(node1);
        System.out.println(palindrome);
    }

    private ListNode reverse(ListNode root){
        ListNode pre = null;
        ListNode curr = root;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
