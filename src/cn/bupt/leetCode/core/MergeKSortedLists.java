package cn.bupt.leetCode.core;

import cn.bupt.leetCode.niuke.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:54 2019/6/25
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists,0,lists.length-1);
    }

    private ListNode mergeList(ListNode[] lists,int left,int right){
        if (left == right){
            return lists[left];
        }
        if (left<right){
            int mid = (left+right)/2;
            ListNode node1 = mergeList(lists, left, mid);
            ListNode node2 = mergeList(lists, mid + 1, right);
            return merge(node1,node2);
        }
        return null;

    }

    private ListNode merge(ListNode node1,ListNode node2){

        ListNode dummpy = new ListNode(-1);
        ListNode curr = dummpy;
        while (node1!=null && node2!=null){
            if (node1.val<node2.val){
                curr.next = node1;
                node1 = node1.next;
            }else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        if (node1!=null){
            curr.next = node1;
        }else {
            curr.next = node2;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(4);
        ListNode node1_3 = new ListNode(5);
        node1_1.next = node1_2;
        node1_2.next = node1_3;

        ListNode node2_1 = new ListNode(1);
        ListNode node2_2 = new ListNode(3);
        ListNode node2_3 = new ListNode(4);
        node2_1.next = node2_2;
        node2_2.next = node2_3;

        ListNode node3_1 = new ListNode(2);
        ListNode node3_2 = new ListNode(6);
        node3_1.next = node3_2;
        ListNode listNodes[] = new ListNode[]{node1_1,node2_1,node3_1};
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode node = mergeKSortedLists.mergeKLists(listNodes);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }


    }
}
