package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:31 2019/6/2
 */
public class ReverseLinkedList2 {

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.

     For example:
     Given1->2->3->4->5->NULL, m = 2 and n = 4,

     return1->4->3->2->5->NULL.

     Note:
     Given m, n satisfy the following condition:
     1 ≤ m ≤ n ≤ length of list.
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode curr = head,pre = dummpy;

        for (int i=1;i<m;i++){
            pre =curr;
            curr = curr.next;
        }

        for (int i=0;i<n-m && curr.next!=null;i++){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        ListNode node = reverseLinkedList2.reverseBetween(node1, 2, 4);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }

}
