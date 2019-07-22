package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:00 2019/4/28
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = (nums[0] + nums[1] +nums[2]);
        for (int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp>target){
                    right--;
                }else {
                    left++;
                }
                if (Math.abs(target - tmp) < Math.abs(target - result)){
                    result = tmp;
                }
            }
        }
        return result;
    }
}
