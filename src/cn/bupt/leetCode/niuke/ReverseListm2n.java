package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:29 2019/1/26
 */
public class ReverseListm2n {

    /**
     * 问题描述
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
    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode startBefore = tempHead;
        ListNode start = head;
        for (int i=1;i<m;i++){
            startBefore = start;
            start = start.next;
        }
        for (int i=0;i<n-m;i++){
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = startBefore.next;
            startBefore.next = temp;
        }

        return tempHead.next;


    }

    public static void visiteList(ListNode root){
        ListNode curr =root;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseBetween(root,2,5);
        visiteList(node);
    }

    public static ListNode reverse2(ListNode head){
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode first =head;
        while (true){
            ListNode temp = first.next;
            if (temp == null){
                break;
            }
            first.next = temp.next;
            temp.next = tempHead.next;
            tempHead.next = temp;
        }
        return tempHead.next;
    }

    public static ListNode reverse1(ListNode head){
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode current = head;
        while (current!=null){
            ListNode tmp = current.next;
            head.next = tmp;
            current.next = tmpHead.next;
            tmpHead.next = current;
            current = tmp;
        }
        return tmpHead.next;
    }

    public static ListNode reverse(ListNode head){

        ListNode pre= null;
        ListNode current = head;
        while (current!=null){
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }

        return head;
    }
}
