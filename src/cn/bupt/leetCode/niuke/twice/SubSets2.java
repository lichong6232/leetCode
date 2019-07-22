package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:54 2019/6/2
 */
public class SubSets2 {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(result,new ArrayList<>(),num,0);
        return result;
    }

    public static void main(String[] args) {
        int num[]= new int[]{1,2,2};
        SubSets2 subSets2 = new SubSets2();
        ArrayList<ArrayList<Integer>> arrayLists = subSets2.subsetsWithDup(num);
        System.out.println(arrayLists);

    }

    private void dfs(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> temp,int num[],int start){
        result.add(new ArrayList<>(temp));
        for (int i=start;i<num.length;i++){
            if (i>start && num[i]== num[i-1]){
                continue;
            }
            temp.add(num[i]);
            dfs(result,temp,num,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
