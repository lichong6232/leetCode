package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:38 2019/8/9
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int mid = nums.length/2;
        for (int i=0;i<mid;i++){
            if (nums[i]>nums[mid]){
                swap(nums,i,mid);
            }
        }
        return nums[mid];
    }


    public static void main(String[] args) {

    }

    private void swap(int nums[],int left,int right){
        if (left!=right){
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
        }
    }
}
