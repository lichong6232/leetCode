package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:24 2019/9/13
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while (curr1 != curr2){
            if (curr1 == null){
                curr1 = headB;
                curr2 = curr2.next;
            }else if (curr2 == null){
                curr2 = headA;
                curr1 = curr1.next;
            }else {
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }
        return curr1;
    }

    public static void main(String[] args) {
        ListNode nodeA_1 = new ListNode(11);
        ListNode nodeA_2 = new ListNode(12);
        ListNode nodeA_3 = new ListNode(13);
        ListNode nodeA_4 = new ListNode(14);
        ListNode nodeA_5 = new ListNode(15);
        ListNode nodeB_1 = new ListNode(1);
        ListNode nodeB_2 = new ListNode(2);
        ListNode nodeB_3 = new ListNode(3);
        ListNode nodeB_4 = new ListNode(4);
        ListNode nodeB_5 = new ListNode(5);
        nodeA_1.next = nodeA_2;
        nodeA_2.next = nodeA_3;
        nodeA_3.next = nodeA_4;
        nodeA_4.next = nodeA_5;
        nodeB_1.next = nodeB_2;
        nodeB_2.next = nodeB_3;
        nodeB_3.next = nodeB_4;
        nodeB_4.next = nodeB_5;
//        nodeB_5.next = nodeA_4;
        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode node = intersectionOfTwoLinkedLists.getIntersectionNode(nodeA_1, nodeB_1);
        System.out.println(node);


    }
}
