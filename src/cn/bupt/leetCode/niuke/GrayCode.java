package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

/**
 * Created by chongli on 2017/7/24.
 */
public class GrayCode {

    public static void main(String args[]){
        GrayCode grayCode=new GrayCode();
        System.out.println(grayCode.grayCode(3));
    }

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if (n<=0){
            res.add(0);
            return res;
        }
        return solve(n);
    }

    public ArrayList<Integer> solve(int n){
        ArrayList<Integer> res=new ArrayList<Integer>();
        if (n==1){
            res.add(0);
            res.add(1);
            return res;
        }
        ArrayList<Integer> tempList=solve(n-1);
        res.addAll(tempList);
        for (int i=tempList.size()-1;i>=0;i--){
            res.add(tempList.get(i)+(int)Math.pow(2,n-1));
        }
        return res;
    }

    public  ArrayList<String> gc(int n){
        ArrayList<String> res=new ArrayList<String>();
        if (n==1){
            res.add("0");
            res.add("1");
            return res;
        }
        ArrayList<String> tempList=gc(n-1);
        for (String s:tempList){
            res.add("0"+s);
        }
        for(int i=tempList.size()-1;i>=0;i--){
            res.add("1"+tempList.get(i));
        }
        return res;
    }

}
