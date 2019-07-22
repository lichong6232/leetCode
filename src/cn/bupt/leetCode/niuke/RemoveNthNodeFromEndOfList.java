package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:27 2019/4/26
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode curr = dummpy,p = dummpy;
        int i = 0;
        while (curr!=null && curr.next!=null){
            if (i++ >=n){
                p = p.next;
            }
            curr = curr.next;
        }
        p.next = p.next.next;
        return dummpy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode head = removeNthNodeFromEndOfList.removeNthFromEnd(node1, 3);
        out(head);
    }

    private static void out(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
