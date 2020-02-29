package cn.bupt.leetCode.niuke;


import java.util.*;

public class SubsetsWithDup {



    public  ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        List<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        res.add(list);
        Arrays.sort(num);
        sove(num,0,res,list);

        return new ArrayList<>(res);
    }


    public static void main(String[] args) {
        int nums[] = new int[]{2,3,3,7};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        ArrayList<ArrayList<Integer>> arrayLists = subsetsWithDup.subsetsWithDup(nums);
        System.out.println(arrayLists);
    }

    public static void sove(int num[], int start, List<ArrayList<Integer>> res,ArrayList<Integer> list){
        for (int i=start;i<num.length;i++){
            if (i==start || num[i-1] != num[i]){
                list.add(num[i]);
                res.add(new ArrayList<Integer>(list));
                sove(num,i+1,res,list);
                list.remove(list.size()-1);
            }
        }

    }
}
