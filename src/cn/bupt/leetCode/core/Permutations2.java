package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:04 2019/8/4
 */
public class Permutations2 {


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num:nums){
            temp.add(num);
        }
        dfs(result,temp,new ArrayList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result,List<Integer> remain,List<Integer> pre){
        if (remain.isEmpty()){
            result.add(new ArrayList<>(pre));
        }else {
            for (int i=0;i<remain.size();i++){
                if (i>0 && remain.get(i-1).equals(remain.get(i))){
                    continue;
                }
                Integer removed = remain.remove(i);
                pre.add(removed);
                dfs(result,remain,pre);
                pre.remove(pre.size()-1);
                remain.add(i,removed);
            }
        }

    }
}
