package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:48 2019/7/16
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }else if (target>nums[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int nums[] = new int[]{1,3,5,6};
        int i = searchInsertPosition.searchInsert(nums, 0);
        System.out.println(i);
    }

}
