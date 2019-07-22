package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:18 2019/4/28
 */
public class TwoSum {

    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        int left = 0,right = num.length-1;
        while (left<right){
            int tmp = num[left] + num[right];
            if (tmp == target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(left);
                list.add(right);
                result.add(list);
                left++;
                right--;
                while (left<right && num[left-1] == num[left]){
                    left++;
                }
                while (left<right && num[right+1] == num[right]){
                    right--;
                }
            }else if (tmp>target){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> twoSum1(int[] num, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<num.length;i++){
            map.put(num[i],i);
        }
        for (int i=0;i<num.length;i++){
            if (map.containsKey(target-num[i]) && map.get(target - num[i])!=i){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(map.get(num[i]));
                list.add(map.get(target - num[i]));
                result.add(list);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int num[] = new int[]{0,2,4,-1,4,6,3,9,7,2,7,6};
        ArrayList<ArrayList<Integer>> arrayLists = twoSum.twoSum(num, 6);
        System.out.println(arrayLists);
    }

}
