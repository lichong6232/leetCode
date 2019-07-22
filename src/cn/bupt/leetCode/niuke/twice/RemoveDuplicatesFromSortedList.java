package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:06 2019/6/2
 */
public class RemoveDuplicatesFromSortedList {

    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.

     For example,
     Given1->1->2, return1->2.
     Given1->1->2->3->3, return1->2->3.
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode curr = head;
        while (curr!=null && curr.next!=null){
            ListNode next = curr.next;
            if (curr.val == next.val){
                curr.next = next.next;
            }else {
                curr = next;
            }

        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        while (head.next!=null && head.val == head.next.val){
            head.next = head.next.next;
        }
        head.next = deleteDuplicates1(head.next);
        return head;
    }





    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node3_1 = new ListNode(3);
        ListNode node3_2 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node4_1 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node3_1;
        node3_1.next = node3_2;
        node3_2.next = node4;
        node4.next = node4_1;
        node4_1.next = node5;
        ListNode node = removeDuplicatesFromSortedList.deleteDuplicates(node1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }



}
