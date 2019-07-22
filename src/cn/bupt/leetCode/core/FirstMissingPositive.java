package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午1:40 2019/7/20
 */
public class FirstMissingPositive {


    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int nums[] = new int[]{3,4,-1,1};
        int i = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(i);
    }


    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0){
            return 1;
        }
        for (int i=0;i<nums.length;i++){
            while (nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1 && nums[i] != nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return nums[nums.length-1]+1;
    }

    private void swap(int nums[],int i,int j){
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }
}
