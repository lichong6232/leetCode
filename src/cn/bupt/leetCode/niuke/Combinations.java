package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:25 2019/2/7
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        search(n,k,1,new ArrayList<>(),res);
        return res;
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        ArrayList<ArrayList<Integer>> combine = combinations.combine(4, 2);
        System.out.println(combine);
    }

    public void search(int n,int k,int start,ArrayList<Integer> tmpList,ArrayList<ArrayList<Integer>> res){
        if (k == 0){
            ArrayList<Integer> list = new ArrayList<>(tmpList);
            res.add(list);
            return;
        }
        for (int i = start;i<=n;i++){
            tmpList.add(i);
            search(n,k-1,i+1,tmpList,res);
            tmpList.remove(tmpList.size()-1);
        }

    }
}
