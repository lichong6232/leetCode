package cn.bupt.leetCode.core;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:14 2019/10/26
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int num:stones){
            queue.add(num);
        }
        while (queue.size()>1){
            int i = queue.poll();
            int j = queue.poll();
            queue.add(Math.abs(i-j));

        }
        return queue.poll();
    }
}
