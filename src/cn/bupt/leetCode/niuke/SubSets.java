package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:06 2019/2/6
 */
public class SubSets {


    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<Integer> tmpList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        this.search(res,tmpList,S,0);
        return res;

    }

    public static void main(String[] args) {
        int S[] = {1,2,3,4};
        SubSets subSets = new SubSets();
        ArrayList<ArrayList<Integer>> subsets = subSets.subsets(S);
        System.out.println(subsets);
    }

    private void search(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmpList,int[] S,int i){
        res.add(new ArrayList<>(tmpList));
        while (i<S.length){
            tmpList.add(S[i]);
            search(res,tmpList,S,i+1);
            tmpList.remove(tmpList.size()-1);
            i++;
        }
    }

}
