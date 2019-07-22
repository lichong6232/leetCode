package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:28 2019/5/1
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        sort(head,null);
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(6);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(10);
        ListNode listNode8 = new ListNode(1);
        ListNode listNode9 = new ListNode(7);
        ListNode listNode10 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;

        SortList sortList = new SortList();
        sortList.sortList(listNode1);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }

    }

    private void sort(ListNode left,ListNode right){
        if (left!=right){
            ListNode partition = partition(left, right);
            sort(left,partition);
            sort(partition.next,right);
        }
    }

    private void swap(ListNode left,ListNode right){
        if (left!=null && right!=null && left!=right){
            left.val = left.val^right.val;
            right.val = left.val^right.val;
            left.val = left.val^right.val;
        }
    }

    private ListNode partition(ListNode left,ListNode right){
        ListNode p = left,q = left.next;
        int temp = left.val;
        while (q!=right){
            if (q.val<temp){
                p = p.next;
                swap(p,q);
            }
            q = q.next;
        }
        swap(left,p);
        return p;
    }

}
