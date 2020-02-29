package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:41 2019/8/14
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0){
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int resultAddr[] = new int[nums.length-k+1];
        for (int i=0;i<nums.length;i++){
            priorityQueue.add(nums[i]);
            if (i>=k){
                priorityQueue.remove(nums[i-k]);
            }
            if (i>=k-1){
                resultAddr[i-k+1] = priorityQueue.peek();
            }
        }
        return resultAddr;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int nums[] = new int[]{1,3,-1,-3,5,3,6,7};
        int[] maxSlidingWindow = slidingWindowMaximum.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(maxSlidingWindow));
    }
}
