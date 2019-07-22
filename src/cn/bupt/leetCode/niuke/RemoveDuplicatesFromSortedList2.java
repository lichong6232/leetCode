package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:21 2019/2/5
 */
public class RemoveDuplicatesFromSortedList2 {


    /**
     * 题目说明
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

     For example,
     Given1->2->3->3->4->4->5, return1->2->5.
     Given1->1->1->2->3, return2->3.
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode slow = tmpHead;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            if (fast.val != fast.next.val){
                slow = fast;
            }else {
                while (fast!=null && fast.next!=null && fast.val == fast.next.val){
                    fast = fast.next;
                }
                slow.next = fast.next;
            }
            fast = fast.next;

        }
        return tmpHead.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }else {
            int tmp = head.val;
            while (head.val == tmp){
                head  = head.next;
                if (head == null){
                    return null;
                }
            }
            return deleteDuplicates(head);
        }

    }



    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        ListNode slow = tmpHead;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            ListNode tmp = fast;
            while (fast!=null && fast.next!=null && fast.val == fast.next.val){
                tmp = fast.next.next;
                fast.next = tmp;
            }
            slow.next = tmp;
            if (tmp != fast){
                fast = tmp;
                continue;
            }
            slow = slow.next;
            fast = fast.next;

        }
        return tmpHead.next;
    }

    private void out(ListNode head){
        ListNode curr = head;
        while (curr!=null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        RemoveDuplicatesFromSortedList2 removeDuplicatesFromSortedList2 = new RemoveDuplicatesFromSortedList2();
        ListNode node = removeDuplicatesFromSortedList2.deleteDuplicates2(head);
        removeDuplicatesFromSortedList2.out(node);


    }
}
