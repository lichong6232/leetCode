package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:26 2019/8/11
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,nums,0,new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(subsets1);
    }

    private void dfs(List<List<Integer>> result ,int nums[],int start,List<Integer> temp){
        result.add(new ArrayList<>(temp));
        for (int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(result,nums,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}
