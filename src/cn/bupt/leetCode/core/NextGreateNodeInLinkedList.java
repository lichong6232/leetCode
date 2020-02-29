package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:45 2019/9/13
 */
public class NextGreateNodeInLinkedList {

    class Node{
        int index;
        int value;
        public Node(int index,int value){
            this.index = index;
            this.value = value;
        }
    }

    private int length(ListNode root){
        ListNode curr =root;
        int i=0;
        while (curr!=null){
            i++;
            curr = curr.next;
        }
        return i;
    }

    public int[] nextLargerNodes(ListNode head) {
        int ans[] = new int[length(head)];
        Stack<Node> stack = new Stack<>();
        ListNode curr = head;
        int i=0;
        while (curr!=null){
            int temp = curr.val;
            while (!stack.isEmpty() && stack.peek().value<temp){
                ans[stack.pop().index] = temp;
            }
            stack.add(new Node(i++,temp));
            curr = curr.next;

        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        NextGreateNodeInLinkedList nextGreateNodeInLinkedList = new NextGreateNodeInLinkedList();
        int[] ints = nextGreateNodeInLinkedList.nextLargerNodes(node1);
        System.out.println(Arrays.toString(ints));
    }

}
