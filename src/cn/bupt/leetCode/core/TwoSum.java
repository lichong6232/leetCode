package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:58 2019/6/21
 */
public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:

     Given nums = [2, 7, 11, 15], target = 9,

     Because nums[0] + nums[1] = 2 + 7 = 9,
     return [0, 1].

     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexMap = new HashMap<>(nums.length);
        int result[] = new int[2];

        for (int i=0;i<nums.length;i++){
            indexMap.put(nums[i],i);
        }
        for (int i=0;i<nums.length;i++){
            if (indexMap.containsKey(target-nums[i]) && indexMap.get(target-nums[i])!=i){
                result[0] = Math.min(i,indexMap.get(target-nums[i]));
                result[1] = Math.max(i,indexMap.get(target-nums[i]));

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2,7,11,15};
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));
    }
}
