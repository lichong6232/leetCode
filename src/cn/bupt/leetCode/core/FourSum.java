package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:50 2019/6/23
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-3;i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int j=i+1;
            while (j<nums.length-2){
                int left = j+1,right = nums.length-1;
                while (left<right){
                    int temp = nums[i]+nums[j]+nums[left]+nums[right];
                    if (temp == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left++],nums[right--]));
                        while (left<right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while (left<right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }else if (temp>target){
                        right--;
                    }else {
                        left++;
                    }
                }
                j++;
                while (j<nums.length-2 && nums[j] == nums[j-1]){
                    j++;
                }
            }
        }
        return result;

    }

}
