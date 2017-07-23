package cn.bupt.leetCode;


import java.util.*;

/**
 * Created by chongli on 2017/7/21.
 */
public class SubsetsWithDup {

    public static void main(String args[]){
        SubsetsWithDup subsetsWithDup=new SubsetsWithDup();
        int num[]={1,1};
        System.out.println(subsetsWithDup.subsetsWithDup(num));
        List list=new ArrayList();
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Set<ArrayList<Integer>> res=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        res.add(list);
        Arrays.sort(num);
        sove(num,0,res,list);

        return new ArrayList<>(res);
    }

    public void sove(int num[], int start, Set<ArrayList<Integer>> res,ArrayList<Integer> list){
        for (int i=start;i<num.length;i++){
            if (i==start || num[i-1] == num[i]){
                list.add(num[i]);
                res.add(new ArrayList<Integer>(list));
                sove(num,i+1,res,list);
                list.remove(list.size()-1);
            }
        }

    }
}
