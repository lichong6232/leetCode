package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:34 2019/7/14
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int i =nums.length-1;
        while (i>0 && nums[i-1]>=nums[i]){
            i--;
        }
        if (i==0){
            reverse(nums,0,nums.length-1);
        }else {
            int left = i-1;
            int right = i+1;
            while (right<nums.length && nums[right]>=nums[left]){
                right++;
            }
            right--;
            swap(nums,left,right);
            reverse(nums,left+1,nums.length-1);
        }

    }

    public static void main(String[] args) {
        int nums[] = new int[]{5,4,7,5,3,2};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int nums[],int i,int j){
        if (i!=j){
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
        }
    }

    private void reverse(int nums[],int left ,int right){
        while (left<right){
            swap(nums,left++,right--);
        }
    }
}
