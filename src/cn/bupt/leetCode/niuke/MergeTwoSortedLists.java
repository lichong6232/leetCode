package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:38 2019/3/28
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode current = head;
        while (current1!=null && current2!=null){
            if (current1.val <= current2.val){
                current.next =current1;
                current1 = current1.next;
            }else {
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }
        if (current1!=null){
            current.next = current1;
        }
        if (current2!=null){
            current.next = current2;
        }
        return head.next;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(6);
        ListNode node14 = new ListNode(9);
        ListNode node15 = new ListNode(15);

        ListNode head2 = new ListNode(4);
        ListNode node21 = new ListNode(7);
        ListNode node22 = new ListNode(8);
        ListNode node23 = new ListNode(11);
        ListNode node24 = new ListNode(13);
        ListNode node25 = new ListNode(20);

        head1.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        head2.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode node = mergeTwoSortedLists.mergeTwoLists(head1, head2);
        out(node);
    }

    public static void out(ListNode node){
        ListNode current = node;
        while (current!=null){
            System.out.println(current.val);
            current = current.next;
        }
    }
}
