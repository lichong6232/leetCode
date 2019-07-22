package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:25 2019/6/2
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode pre = dummpy,curr = dummpy;
        while (curr.next!=null){
            ListNode next = curr.next;
            if (next.val<x){
                if (curr == pre){
                    curr = next;
                    pre = next;
                }else {
                    curr.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                    pre = next;
                }
            }else {
                curr = next;
            }
        }
        return dummpy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node2_1 = new ListNode(2);
        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node2_1;
        PartitionList partitionList = new PartitionList();
        ListNode partition = partitionList.partition(node1, 3);
        ListNode node = partition;
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
