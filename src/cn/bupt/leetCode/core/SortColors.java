package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:57 2019/8/10
 */
public class SortColors {

    public void sortColors(int[] nums) {

        for (int i=1;i<nums.length;i++){
            if (nums[i] == 0){
                int k = i-1;
                while (k>=0 && nums[k]!=0){
                    nums[k+1] = nums[k];
                    k--;
                }
                nums[k+1] = 0;
            }
        }

        for (int j=nums.length-2;j>=0;j--){
            if (nums[j] == 2){
                int k = j+1;
                while (k<=nums.length-1 && nums[k]!=2){
                    nums[k-1] = nums[k];
                    k++;
                }
                nums[k-1] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,0,2,0,0,1,0,2,1,0,1};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
