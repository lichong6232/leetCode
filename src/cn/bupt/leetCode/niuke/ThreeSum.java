package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:40 2019/4/28
 */
public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int num[], int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0;i < num.length-2;i++){
            if (i>0 && num[i] == num[i-1]){
                continue;
            }
            int left = i+1;
            int right = num.length-1;
            while (left<right){
                int tmp = num[i]+num[left]+num[right];
                if (tmp == target){
                    result.add(new ArrayList<>(Arrays.asList(num[i],num[left++],num[right--])));
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
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int num[] = new int[]{8,5,2,5,7,9,0,2,-1,-3,4,6,7,10,1,-2};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum.threeSum(num, 4);
        System.out.println(arrayLists);
    }
}
