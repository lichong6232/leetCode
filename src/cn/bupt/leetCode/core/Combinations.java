package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:56 2019/8/10
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,new ArrayList<>(),k,1,n);
        return result;
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine(4, 2);
        System.out.println(combine);
    }

    private void dfs(List<List<Integer>> result,List<Integer> temp,int k,int i,int n){
        if (k==0){
            result.add(new ArrayList<>(temp));
        }else {
            for (;i<=n;i++){
                temp.add(i);
                dfs(result,temp,k-1,i+1,n);
                temp.remove(temp.size()-1);
            }
        }
    }
}
