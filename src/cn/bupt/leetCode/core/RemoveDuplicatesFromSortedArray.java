package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:26 2019/6/25
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int j=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]!=nums[j-1]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int length = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        for (int i=0;i<length;i++){
            System.out.println(nums[i]);
        }

    }
}
