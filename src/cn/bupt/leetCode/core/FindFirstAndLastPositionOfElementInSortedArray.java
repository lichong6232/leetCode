package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:09 2019/7/15
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int index[] = new int[2];
        index[0] = -1;
        index[1] = -1;
        if (nums.length==0){
            return index;
        }
        int leftIndex = findIndex(nums,target,true);
        if (leftIndex==-1){
            return index;
        }
        int rightIndex = findIndex(nums,target,false);
        index[0] = leftIndex;
        index[1] = rightIndex;
        return index;

    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        int nums[] = new int[]{5,7,7,8,8,10};
        int[] ints = findFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
    }

    /*private int findRightIndex(int nums[], int target){
        int left=0,right = nums.length-1;
        while (left<right){
            int mid = (left+right+1)/2;
            if (target==nums[mid]){
                left = mid;
            }else if (target<nums[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left < nums.length && nums[left]==target?left:-1;

    }


    private int findLeftIndex(int nums[],int target){
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (target==nums[mid]){
                right = mid;
            }else if (target>nums[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left>=0 && nums[left] == target?left:-1;

    }
*/
    private int findIndex(int nums[],int target,boolean isLeft){
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = (left+right+(isLeft?0:1))/2;
            if (nums[mid] == target){
                if (isLeft){
                    right = mid;
                }else {
                    left = mid;
                }

            }else if (target>nums[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left>=0 && left<nums.length && nums[left] == target?left:-1;
    }

}
