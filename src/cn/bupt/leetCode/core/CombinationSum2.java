package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:16 2019/7/20
 */
public class CombinationSum2 {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        dfs(list,new ArrayList<>(),candidates,target,0);

        return list;
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int candidates[] = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2.combinationSum2(candidates, 8);
        System.out.println(lists);
    }

    private void dfs(List<List<Integer>> list,List<Integer> temp,int candidates[],int target,int k){
        if (target<0){
            return;
        }
        if (target == 0){
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i=k;i<candidates.length;i++){
            if (i>k && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            dfs(list,temp,candidates,target - candidates[i],i+1);
            temp.remove(temp.size()-1);
        }


    }
}
