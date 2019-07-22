package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:33 2019/4/20
 */
public class SwapNodesInPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.

     For example,
     Given1->2->3->4, you should return the list as2->1->4->3.

     Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     解题思路：每交换一次，改变pre指针与curr指针
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummpy = new ListNode(0),pre = dummpy,curr=head;
        dummpy.next = head;
        while (curr!=null && curr.next!=null){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            pre = curr;
            curr = curr.next;
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
//        listNode7.next = listNode8;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode listNode = swapNodesInPairs.swapPairs(listNode1);
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
