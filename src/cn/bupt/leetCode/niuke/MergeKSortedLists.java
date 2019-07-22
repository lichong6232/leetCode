package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:13 2019/4/20
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0){
            return null;
        }
        return merge(lists,0,lists.size()-1);
    }

    private ListNode merge(ArrayList<ListNode> listNodes,int left,int right){
        if (left<right){
            int mid = (left+1)>>1;
            ListNode nod1 = merge(listNodes, left, mid);
            ListNode node2 = merge(listNodes,mid+1,right);
            return merge(nod1,node2);
        }
        return listNodes.get(left);
    }

    private ListNode merge(ListNode node1,ListNode node2){
        ListNode dummpy = new ListNode(0),tmp=dummpy;
        while (node1!=null && node2!=null){
            if (node1.val<node2.val){
                tmp.next = node1;
                node1 = node1.next;
            }else {
                tmp.next = node2;
                node2 = node2.next;
            }
            tmp = tmp.next;

        }
        if (node1!=null){
            tmp.next = node1;
        }
        if (node2!=null){
            tmp.next = node2;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(7);
        ListNode listNode14 = new ListNode(9);
        ListNode listNode15 = new ListNode(11);
        ListNode listNode16 = new ListNode(14);
        ListNode listNode17 = new ListNode(19);
        ListNode listNode18 = new ListNode(24);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        listNode15.next = listNode16;
        listNode16.next = listNode17;
        listNode17.next = listNode18;

        ArrayList<ListNode> listNodes = new ArrayList<>();
        listNodes.add(listNode11);
        ListNode listNode21 = new ListNode(3);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(8);
        ListNode listNode24 = new ListNode(9);
        ListNode listNode25 = new ListNode(17);
        ListNode listNode26 = new ListNode(18);
        ListNode listNode27 = new ListNode(19);
        ListNode listNode28 = new ListNode(20);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        listNode24.next = listNode25;
        listNode25.next = listNode26;
        listNode26.next = listNode27;
        listNode27.next = listNode28;
        listNodes.add(listNode21);
        ListNode listNode31 = new ListNode(6);
        ListNode listNode32 = new ListNode(9);
        ListNode listNode33 = new ListNode(10);
        ListNode listNode34 = new ListNode(11);
        ListNode listNode35 = new ListNode(30);
        listNode31.next = listNode32;
        listNode32.next = listNode33;
        listNode33.next = listNode34;
        listNode34.next = listNode35;
        listNodes.add(listNode31);
        ListNode listNode = mergeKSortedLists.mergeKLists(listNodes);
        out(listNode);

    }

    private static void out(ListNode head){
        ListNode curr = head;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }



}
