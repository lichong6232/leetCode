package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:30 2019/9/16
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int sum =0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            sum+= nums[i];
            count += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int nums[] = new int[]{1,1,1};
        int i = subarraySumEqualsK.subarraySum(nums, 2);
        System.out.println(i);
    }
}
