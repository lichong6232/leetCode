package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:25 2019/4/27
 */
public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        for (int i=0;i<num.length-3;i++){
            if (i>0 && num[i-1] == num[i]){
                continue;
            }
            for (int j=i+1;j<num.length-2;){
                int left = j+1;
                int right = num.length-1;
                while (left<right){
                    int tmp = num[i] + num[j] + num[left] + num[right];
                    if (tmp == target){
                        result.add(new ArrayList<>(Arrays.asList(num[i],num[j],num[left],num[right])));
                        left++;
                        right--;
                        while (left<right && num[left-1] == num[left]){
                            left++;
                        }
                        while (left<right && num[right+1] == num[right]){
                            right--;
                        }
                    }else if(tmp>target){
                        right--;
                    }else {
                        left++;
                    }
                }
                j++;
                while (j<num.length-2 && num[j-1] == num[j]){
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int num[] = new int[]{-1,0,-5,-2,-2,-4,0,1,-2};
        ArrayList<ArrayList<Integer>> arrayLists = fourSum.fourSum(num, -9);
        System.out.println(arrayLists);
    }
}
