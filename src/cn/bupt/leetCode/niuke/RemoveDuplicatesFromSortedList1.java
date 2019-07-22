package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:53 2019/2/5
 */
public class RemoveDuplicatesFromSortedList1 {


    /*
    问题描述：
    Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given1->1->2, return1->2.
Given1->1->2->3->3, return1->2->3.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.val == head.next.val){
            while (head.next != null && head.next!=null && head.val == head.next.val){
                head.next = head.next.next;
            }

        }
        head.next = deleteDuplicates(head.next);
        return head;
    }


    public ListNode deleteDuplicates1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        while (curr!= null && curr.next!=null){
            if (curr.val != curr.next.val){
                curr = curr.next;
            }else {
                while (curr!=null && curr.next!=null && curr.val == curr.next.val){
                    curr.next = curr.next.next;
                }
            }
        }
        return head;
    }

    private void out(ListNode head){
        ListNode curr = head;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        RemoveDuplicatesFromSortedList1 removeDuplicatesFromSortedList1 = new RemoveDuplicatesFromSortedList1();
        ListNode node = removeDuplicatesFromSortedList1.deleteDuplicates(head);
        removeDuplicatesFromSortedList1.out(node);

    }
}
