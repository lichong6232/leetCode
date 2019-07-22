package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:20 2019/4/6
 */
public class Permutations2 {



    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        result.add(toList(num));
        while (true){
            int i = num.length-1;
            while (i>0 && num[i-1]>=num[i]){
                i--;
            }
            if (i==0){
                return result;
            }
            int left = i-1;
            int right = i+1;
            while (right<num.length && num[right]>num[left]){
                right++;
            }
            right--;
            swap(num,left,right);
            reverse(num,left+1,num.length-1);
            result.add(toList(num));
        }
    }

    private ArrayList<Integer> toList(int num[]){
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : num){
            list.add(n);
        }
        return list;
    }

    private void reverse(int num[],int start,int end){
        while (start<end){
            swap(num,start++,end--);
        }
    }

    private void swap(int num[],int i,int j){
        if (i!=j){
            num[i] = num[i]^num[j];
            num[j] = num[i]^num[j];
            num[i] = num[i]^num[j];
        }
    }



    /**
     * 递归法
     * @param temp
     * @param result
     * @param list
     */
    private void permute(ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list){
        if (list.isEmpty()){
            result.add(new ArrayList<>(temp));
        }else {
            for (int i=0;i<list.size();i++){
                if (i>0 && list.get(i-1).equals(list.get(i))){
                    continue;
                }
                Integer removed = list.remove(i);
                temp.add(removed);
                permute(temp,result,list);
                temp.remove(removed);
                list.add(i,removed);
            }
        }
    }

    public static void main(String[] args) {
        Permutations2 permutations2 = new Permutations2();
        ArrayList<ArrayList<Integer>> arrayLists = permutations2.permuteUnique(new int[]{3,4,2,1,5});
        System.out.println(arrayLists);
    }

}
