package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:06 2019/6/2
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        if (head.val == head.next.val){
            ListNode curr = head;
            int temp = curr.val;
            while (curr!= null && curr.val==temp){
                curr = curr.next;
            }
            return deleteDuplicates(curr);
        }else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
