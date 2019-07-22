package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:55 2019/7/15
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] == nums[left] && nums[mid] == nums[right]){
                for (int i=left;i<=right;i++){
                    if (nums[i] == target){
                        return i;
                    }
                }
                return -1;
            }
            if (nums[mid]>nums[right]){
                if (target<nums[mid] && target>=nums[left]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,3};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int search = searchInRotatedSortedArray.search(nums, 3);
        System.out.println(search);
    }

}
