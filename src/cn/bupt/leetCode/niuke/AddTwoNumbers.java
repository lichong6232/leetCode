package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:05 2019/4/29
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode current1 = l1,current2=l2,pre1=null;
        int in=0;
        while (current1!=null && current2!=null){
            current1.val = current1.val + current2.val;
            pre1 = current1;
            current1 = current1.next;
            current2 = current2.next;
        }
        if (current1==null){
            pre1.next = current2;
        }
        current1 = l1;
        while (current1!=null){
            int tmp = current1.val + in;
            if (tmp>=10){
                in=1;
                current1.val = tmp - 10;
            }else {
                current1.val = tmp;
                in=0;
            }
            pre1 = current1;
            current1 = current1.next;
        }
        if (in==1){
            pre1.next = new ListNode(1);
        }
        return l1;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(4);
        ListNode listNode13 = new ListNode(3);
        ListNode listNode14 = new ListNode(6);
        ListNode listNode15 = new ListNode(7);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = listNode15;
        ListNode listNode21 = new ListNode(5);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode23 = new ListNode(4);
        ListNode listNode24 = new ListNode(5);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = listNode24;
        ListNode node = addTwoNumbers.addTwoNumbers(listNode11, listNode21);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }


}
