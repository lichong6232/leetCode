package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:33 2019/9/9
 */
public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = len(root);
        int width = len/k;
        int reminder = len%k;
        ListNode nodes[] = new ListNode[k];
        ListNode curr = root;
        for (int i=0;i<k;i++){
            int steep = width+(i<reminder?1:0);
            nodes[i] = curr;
            while (steep>1){
                curr = curr.next;
                steep--;
            }
            if (curr!=null){
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }

        }
        return nodes;

    }

    public static void main(String[] args) {
        ListNode node1= new ListNode(1);
        ListNode node2= new ListNode(2);
        ListNode node3= new ListNode(3);
        /*ListNode node4= new ListNode(4);
        ListNode node5= new ListNode(5);
        ListNode node6= new ListNode(6);
        ListNode node7= new ListNode(7);
        ListNode node8= new ListNode(8);
        ListNode node9= new ListNode(9);
        ListNode node10= new ListNode(10);*/

        node1.next = node2;
        node2.next = node3;
        /*node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;*/
        SplitLinkedListInParts splitLinkedListInParts = new SplitLinkedListInParts();
        ListNode[] listNodes = splitLinkedListInParts.splitListToParts(node1, 5);
        for (ListNode node : listNodes){
            visit(node);
            System.out.println("================");
        }
    }

    private static void visit(ListNode node){
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    private int len(ListNode root){
        int i=0;
        ListNode curr = root;
        while (curr!=null){
            curr = curr.next;
            i++;
        }
        return i;
    }

    private ListNode[] split(ListNode root,int k,int len){
        if (k==1){
            return new ListNode[]{root};
        }
        if (k>=len){
            ListNode nodes[] = new ListNode[k];
            ListNode curr = root;
            int i=0;
            while (curr!=null){
                nodes[i++] = curr;
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
            return nodes;
        }
        int leftK = k/2;
        int rightK = k - leftK;
        ListNode mid = getMid(root);
        ListNode next = mid.next;
        mid.next = null;
        int rightLen = len/2;
        int leftLen = len - rightLen;
        ListNode[] leftNodes = split(mid, leftK, leftLen);
        ListNode[] rightNodes = split(next, rightK, rightLen);
        ListNode nodes[] = new ListNode[k];
        int i=0;
        for (ListNode node : leftNodes){
            nodes[i++] = node;
        }
        for (ListNode node : rightNodes){
            nodes[i++] = node;
        }
        return nodes;

    }

    private ListNode getMid(ListNode root){
        if (root == null){
            return null;
        }

        ListNode fast = root;
        ListNode slow = root;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
