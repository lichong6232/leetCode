package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:12 2019/3/28
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null){
            return null;
        }

        int count = 1;
        ListNode current = head;
        while (current.next!=null){
            current = current.next;
            count ++;
        }
        n = n%count;
        current.next = head;
        int i=1;
        while (i<=count-n){
            current = current.next;
            i++;
        }
        ListNode result = current.next;
        current.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
        RotateList rotateList = new RotateList();
        ListNode node = rotateList.rotateRight(node1, 2);
        out(node);
    }

    public static void out(ListNode node){
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
