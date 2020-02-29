package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:23 2019/9/8
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dumppy = new ListNode(-1);
        dumppy.next = head;
        ListNode pre = dumppy,curr=dumppy;
        while (curr!=null && curr.next!=null){
            if (curr.next.val<x){
                if (pre == curr){
                    pre = pre.next;
                    curr = curr.next;
                }else {
                    ListNode node = curr.next;
                    ListNode next = node.next;
                    curr.next = next;
                    node.next = pre.next;
                    pre.next = node;
                    pre = node;
                }

            }else {
                curr = curr.next;
            }
        }
        return dumppy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node2_2 = new ListNode(6);
        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node2_2;
        PartitionList partitionList = new PartitionList();
        ListNode partition = partitionList.partition(node1, 8);
        ListNode curr  = partition;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }


    }


}
