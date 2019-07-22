package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:17 2019/4/9
 */
public class CombinationSum1 {


    /**
     * 问题描述：
     * Given a set of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .

     The same repeated number may be chosen from C unlimited number of times.

     Note:

     All numbers (including target) will be positive integers.
     Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
     The solution set must not contain duplicate combinations.

     For example, given candidate set2,3,6,7and target7,
     A solution set is:
     [7]
     [2, 2, 3]


     * @param candidates
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(tmp,result,target,0,candidates);
        return result;
    }

    public static void main(String[] args) {
        CombinationSum1 combinationSum1 = new CombinationSum1();
        int num[] = new int[]{2,3,6,7};

        ArrayList<ArrayList<Integer>> arrayLists = combinationSum1.combinationSum(num, 7);
        System.out.println(arrayLists);
    }

    private void dfs(ArrayList<Integer> tmp,ArrayList<ArrayList<Integer>> result,int target,int k,int[] num){
        if (target == 0){
            result.add(new ArrayList<Integer>(tmp));
        }else if (target>0){
            for (int i=k;i<num.length;i++){
                tmp.add(num[i]);
                dfs(tmp,result,target-num[i],i,num);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
