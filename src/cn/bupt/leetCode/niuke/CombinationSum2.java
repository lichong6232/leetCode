package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:05 2019/4/9
 */
public class CombinationSum2 {


    /**
     * 问题描述：
     * Given a collection of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .

     Each number in C may only be used once in the combination.

     Note:

     All numbers (including target) will be positive integers.
     Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
     The solution set must not contain duplicate combinations.

     For example, given candidate set10,1,2,7,6,1,5and target8,
     A solution set is:
     [1, 7]
     [1, 2, 5]
     [2, 6]
     [1, 1, 6]
     * @param num
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        dfs(tmp,result,target,0,num);
        return result;
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int num[] = new int[]{10,1,2,7,6,1,5};

        ArrayList<ArrayList<Integer>> arrayLists = combinationSum2.combinationSum2(num, 8);
        System.out.println(arrayLists);
    }

    private void dfs(ArrayList<Integer> tmp,ArrayList<ArrayList<Integer>> result,int target,int k,int[] num){
        if (target == 0){
            result.add(new ArrayList<Integer>(tmp));
        }else if (target>0){

            for (int i=k;i<num.length;i++){
                if (i>k && num[i] == num[i-1]){
                    continue;
                }
                tmp.add(num[i]);
                dfs(tmp,result,target-num[i],i+1,num);
                tmp.remove(tmp.size()-1);
            }
        }
    }

}
