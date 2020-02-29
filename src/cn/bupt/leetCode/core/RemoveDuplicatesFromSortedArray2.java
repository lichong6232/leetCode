package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:33 2019/9/16
 */
public class RemoveDuplicatesFromSortedArray2 {


    public int removeDuplicates(int[] nums) {
        if (nums.length<=2){
            return nums.length;
        }
        int duplicateCount = 2;
        int pre = duplicateCount;
        int count=duplicateCount;
        for (int i=duplicateCount;i<nums.length;i++){
            if (nums[i]!=nums[pre-duplicateCount]){
                nums[pre++] = nums[i];
                count++;
            }
        }
        return count;

    }
}
