package cn.bupt.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chongli on 2017/7/21.
 */
public class AllPossibleCombination {

    public static void main(String args[]){
        AllPossibleCombination allPossibleCombination=new AllPossibleCombination();
        System.out.println(allPossibleCombination.combine(4,2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        solve(n,k,0,res,list);
        return res;
    }

    public void solve(int n,int k,int start,List<List<Integer>> res,List<Integer> list){
        if (k<0)
            return;
        if (k==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=start;i<=n;i++){
            list.add(i);
            solve(n,k-1,i+1,res,list);
            list.remove(list.size()-1);
        }
    }

}
