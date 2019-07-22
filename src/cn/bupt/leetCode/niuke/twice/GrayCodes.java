package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:31 2019/6/2
 */
public class GrayCodes {

    public static void main(String[] args) {
        GrayCodes grayCodes = new GrayCodes();
        ArrayList<ArrayList<Integer>> arrayLists = grayCodes.grayCodes(3);
        System.out.println(arrayLists);

    }



    public ArrayList<ArrayList<Integer>> grayCodes(int n){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (n==1){
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            list1.add(0);
            list2.add(1);
            result.add(list1);
            result.add(list2);
            return result;
        }else {
            ArrayList<ArrayList<Integer>> tempList = grayCodes(n-1);
            for (int i=0;i<tempList.size();i++){
                ArrayList<Integer> list = new ArrayList<>(tempList.get(i));
                list.add(0,0);
                result.add(list);
            }
            for (int i=tempList.size()-1;i>=0;i--){
                ArrayList<Integer> list = new ArrayList<>(tempList.get(i));
                list.add(0,1);
                result.add(list);
            }
        }
        return result;

    }
}
