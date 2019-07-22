package cn.bupt.leetCode.niuke;

import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:40 2019/4/20
 */
public class ReverseNodesInKGroup {

    /**
     * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

     If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

     You may not alter the values in the nodes, only nodes itself may be changed.

     Only constant memory is allowed.

     For example,
     Given this linked list:1->2->3->4->5

     For k = 2, you should return:2->1->4->3->5

     For k = 3, you should return:3->2->1->4->5
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k<2){
            return head;
        }

        int count = 0;
        ListNode curent = head;
        while (curent!=null){
            count++;
            curent = curent.next;
        }
        ListNode dummpy = new ListNode(0),pre = dummpy;
        dummpy.next = head;
        for (int i=1;i<=count/k;i++){
            for (int j=1;j<k;j++){
                ListNode next = head.next;
                head.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = head;
            head = pre.next;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode reverse = reverseNodesInKGroup.reverseKGroup(listNode1, 2);
//        ListNode reverse = reverseNodesInKGroup.reverse(listNode1, 5);
        out(reverse);
    }

    private static void out(ListNode head){
        ListNode curr = head;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    private ListNode reverse(ListNode head,int k){

        ListNode pre = head;
        while (k-->0){
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre;
            pre = next;
        }
        return pre;
    }

}
