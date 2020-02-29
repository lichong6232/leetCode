package cn.bupt.leetCode.core;


import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:43 2019/8/6
 */
public class RotateList {

    /**
     * Given a linked list, rotate the list to the right by k places, where k is non-negative.

     Example 1:

     Input: 1->2->3->4->5->NULL, k = 2
     Output: 4->5->1->2->3->NULL
     Explanation:
     rotate 1 steps to the right: 5->1->2->3->4->NULL
     rotate 2 steps to the right: 4->5->1->2->3->NULL
     Example 2:

     Input: 0->1->2->NULL, k = 4
     Output: 2->0->1->NULL
     Explanation:
     rotate 1 steps to the right: 2->0->1->NULL
     rotate 2 steps to the right: 1->2->0->NULL
     rotate 3 steps to the right: 0->1->2->NULL
     rotate 4 steps to the right: 2->0->1->NULL
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }

        int count = 1;
        ListNode current = head;
        while (current.next!=null){
            current = current.next;
            count ++;
        }
        k = k%count;
        current.next = head;
        int i=1;
        while (i<=count-k){
            current = current.next;
            i++;
        }
        ListNode result = current.next;
        current.next = null;
        return result;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        ListNode node = rotateList.rotateRight(node1, 4);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }

}
