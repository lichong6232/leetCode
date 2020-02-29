package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:40 2019/9/14
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        Map<Integer,ListNode> map = new HashMap<>();
        int sum=0;
        for (ListNode node = dummpy;node!=null;node = node.next){
            sum+=node.val;
            map.put(sum,node);
        }

        sum =0;
        for (ListNode node = dummpy;node!=null;node = node.next){
            sum+=node.val;
            node.next = map.get(sum).next;
        }
        return dummpy.next;

    }
}
