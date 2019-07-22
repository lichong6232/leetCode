package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:12 2019/1/26
 */
public class ListSubset {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<>();
        search(0,num,list);
        return result;

    }

    private void search(int start,int[] num,ArrayList<Integer> list){
        result.add(list);
        for (int i=start;i<num.length;i++){
            //[2,2,2,3,4]去除掉后面的重复数字
            if (i>start && num[i]==num[i-1]){
                continue;
            }
            list.add(num[i]);
            ArrayList<Integer> tmpList = new ArrayList(list);
            search(i+1,num,tmpList);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        int num[] = {1,2,2};
        ListSubset listSubset = new ListSubset();
        ArrayList<ArrayList<Integer>> arrayLists = listSubset.subsetsWithDup(num);
        System.out.println(arrayLists);
    }




}
