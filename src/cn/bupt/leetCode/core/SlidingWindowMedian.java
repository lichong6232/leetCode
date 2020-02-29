package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:30 2019/8/14
 */
public class SlidingWindowMedian {


    /**
     * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

     Examples:
     [2,3,4] , the median is 3

     [2,3], the median is (2 + 3) / 2 = 2.5

     Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

     For example,
     Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

     Window position                Median
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       1
     1 [3  -1  -3] 5  3  6  7       -1
     1  3 [-1  -3  5] 3  6  7       -1
     1  3  -1 [-3  5  3] 6  7       3
     1  3  -1  -3 [5  3  6] 7       5
     1  3  -1  -3  5 [3  6  7]      6
     Therefore, return the median sliding window as [1,-1,-1,3,5,6].

     Note:
     You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();
        double[] address = new double[nums.length-k+1];
        for (int i=0;i<nums.length;i++){
            if (!max.isEmpty() && nums[i]>max.peek()){
                max.add(nums[i]);
            }else {
                min.add(nums[i]);
            }
            if (i>=k){
                if (!min.remove(nums[i-k])){
                    max.remove(nums[i-k]);
                }
            }
            if (i>=k-1){
                while (min.size()>max.size()+1){
                    max.add(min.poll());
                }
                while (max.size()>min.size()){
                    min.add(max.poll());
                }
                if (k%2==0){
                    address[i-k+1] = (max.peek()*1.0 + min.peek()*1.0)/2;
                }else {
                    address[i-k+1] = min.peek();
                }
            }

        }
        return address;

    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        int nums[] = new int[]{2147483647,2147483647};
        double[] doubles = slidingWindowMedian.medianSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(doubles));

    }
}
