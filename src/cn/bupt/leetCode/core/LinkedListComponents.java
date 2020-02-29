package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:14 2019/9/11
 */
public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G){
            set.add(g);
        }
        ListNode curr = head;
        int ans = 0;
        while (curr!=null){
            if (set.contains(curr.val) && (curr.next == null || !set.contains(curr.next.val))){
                ans++;
            }
            curr = curr.next;
        }
        return ans;

    }
}
