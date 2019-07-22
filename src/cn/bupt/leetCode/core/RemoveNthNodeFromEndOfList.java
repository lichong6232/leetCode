package cn.bupt.leetCode.core;

import cn.bupt.leetCode.niuke.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:56 2019/6/23
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k=0;
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode p = dummpy,q = dummpy;
        while (p!=null){
            p=p.next;
            if (k>n){
                q = q.next;
            }
            k++;
        }
        q.next = q.next.next;
        return dummpy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode node = removeNthNodeFromEndOfList.removeNthFromEnd(node1, 2);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }

}
