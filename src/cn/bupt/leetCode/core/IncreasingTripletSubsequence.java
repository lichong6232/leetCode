package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:55 2019/9/25
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet1(int[] nums) {
        if (nums.length <3){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MAX_VALUE);
        for (int num : nums){
            if (num<=list.get(0)){
                list.set(0,num);
            }else if (num<=list.get(list.size()-1)){
                list.set(list.size()-1,num);
            }else {
                list.add(num);
                if (list.size() == 3){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean increasingTriplet(int[] nums) {
        if (nums.length <3){
            return false;
        }
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int num: nums){
            if (num<=one){
                one = num;
            }else if (num<=two){
                two = num;
            }else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        int nums[] = new int[]{1,1,1,1,1};
        boolean b = increasingTripletSubsequence.increasingTriplet(nums);
        System.out.println(b);
    }
}
