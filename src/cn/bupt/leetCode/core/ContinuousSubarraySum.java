package cn.bupt.leetCode.core;

import sun.jvm.hotspot.utilities.Interval;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:05 2019/9/16
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0){
            return false;
        }
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            if (k != 0){
                sum%=k;
            }
            if (map.containsKey(sum)){
                if (i-map.get(sum)>1){
                    return true;
                }

            }else {
                map.put(sum,i);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        int nums[] = new int[]{0,0};
        boolean b = continuousSubarraySum.checkSubarraySum(nums, 0);
        System.out.println(b);
    }
}
