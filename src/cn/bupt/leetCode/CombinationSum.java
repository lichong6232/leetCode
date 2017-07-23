package cn.bupt.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chongli on 2017/7/21.
 */
public class CombinationSum {

    public static void main(String args[]){
        CombinationSum combinationSum=new CombinationSum();
        int candidates[]={2,3,6,7};
        System.out.println(combinationSum.combinationSum(candidates,7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        solve(candidates,target,res,list,0);
        return res;
    }

    private void solve(int candidates[],int target,List<List<Integer>> res,List<Integer> list,int start){
        if (target==0){
            res.add(new ArrayList<Integer>(list));
        }
        for (int i=start;i<candidates.length;i++){
            int value=candidates[i];
            int surplus=target-value;
            if (surplus<0)
                continue;
            list.add(value);
            solve(candidates,surplus,res,list,i);
            list.remove(list.size()-1);
        }
    }

}
