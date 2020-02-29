package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:31 2019/9/25
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int max = 0;
        Set<Integer> keySet = map.keySet();
        for (int key : keySet){
            if (map.containsKey(key+1)){
                max = Math.max(map.get(key+1)+map.get(key),max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        int nums[] = new int[]{1,3,2,2,5,2,3,7};
        int lhs = longestHarmoniousSubsequence.findLHS(nums);
        System.out.println(lhs);
    }
}
