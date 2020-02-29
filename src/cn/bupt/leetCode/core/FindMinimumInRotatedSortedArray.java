package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:57 2019/8/8
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

     (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

     Find the minimum element.

     You may assume no duplicate exists in the array.

     Example 1:

     Input: [3,4,5,1,2]
     Output: 1
     Example 2:

     Input: [4,5,6,7,0,1,2]
     Output: 0
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]<nums[right]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int nums[] = new int[]{4,3,0,1,2};
        int min = findMinimumInRotatedSortedArray.findMin(nums);
        System.out.println(min);
    }
}
