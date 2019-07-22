package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:17 2019/6/23
 */
public class ThreeSum {

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

     Note:

     The solution set must not contain duplicate triplets.

     Example:

     Given array nums = [-1, 0, 1, 2, -1, -4],

     A solution set is:
     [
     [-1, 0, 1],
     [-1, -1, 2]
     ]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<nums.length-2;i++){
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1,right = nums.length-1;
            while (left<right){
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == 0){
                    result.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                    while (left<nums.length && nums[left] == nums[left-1]){
                        left++;
                    }
                    while (right >=0 && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if (temp>0){
                    right--;
                }else {
                    left++;
                }
            }


        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int nums[] = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists);
    }
}
