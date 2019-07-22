package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:27 2019/5/11
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode curr1 = head,curr2 = reverse(mid.next);
        mid.next = null;
        while (curr1!=null && curr2!=null){
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr2.next = curr1.next;
            curr1.next = curr2;
            curr1 = next1;
            curr2 = next2;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode pre= null;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverse1(ListNode head){
        ListNode dummp = new ListNode(0);
        dummp.next = head;
        ListNode curr= head.next;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = dummp.next;
            dummp.next = curr;
            curr = next;
        }
        return dummp.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(node1);
        out(node1);

    }

    public static void out(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    private ListNode getMid(ListNode head){
        if (head == null){
            return null;
        }
        ListNode slow = head,fast = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
