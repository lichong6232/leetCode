package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:49 2019/9/26
 */
public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(new ArrayList<Integer>(),result,nums,0);
        return result;

    }

    public static void main(String[] args) {
        IncreasingSubsequences increasingSubsequences = new IncreasingSubsequences();
        int nums[] = new int[]{100,90,80,70,60,50,60,70,80,90,100};
        List<List<Integer>> subsequences = increasingSubsequences.findSubsequences(nums);
        System.out.println(subsequences);
    }

    private void recursion(List<Integer> temp,List<List<Integer>> result,int nums[],int start){
        Set<Integer> set = new HashSet<>();
        for (int i=start;i<nums.length;i++){
            if(!set.contains(nums[i])){
                if (temp.isEmpty() || temp.get(temp.size()-1)<=nums[i]){
                    temp.add(nums[i]);
                    if (temp.size()>1){
                        result.add(new ArrayList<>(temp));
                    }
                    recursion(temp,result,nums,i+1);
                    temp.remove(temp.size()-1);
                }
                set.add(nums[i]);

            }

        }
    }
}
