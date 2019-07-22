package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:56 2019/7/19
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        dfs(new ArrayList<>(),list,target,candidates,0);
        return list;
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int candidates[] = new int[]{2,3,6,7};
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, 7);
        System.out.println(lists);
    }

    private void dfs(List<Integer> temp,List<List<Integer>> list,int target,int candidates[],int n){
        if (target < 0){
            return;
        }
        if (target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = n;i < candidates.length;i++){
            temp.add(candidates[i]);
            dfs(temp,list,target - candidates[i],candidates,i);
            temp.remove(temp.size()-1);
        }
    }
}
