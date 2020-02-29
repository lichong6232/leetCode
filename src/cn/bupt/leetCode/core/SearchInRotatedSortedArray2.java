package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:40 2019/9/16
 */
public class SearchInRotatedSortedArray2 {


    public boolean search(int[] nums, int target) {
        if (nums.length == 0){
            return false;
        }
        int left = 0,right = nums.length-1;
        while (left<=right){
            int mid = (left)+(right-left)/2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[right] && nums[left] == nums[mid]){
                for (int i=left;i<=right;i++){
                    if (nums[i] == target){
                        return true;
                    }
                }
                return false;
            }

            if (nums[left]<=nums[mid]){
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
        return false;

    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,3,5};
        SearchInRotatedSortedArray2 searchInRotatedSortedArray2 = new SearchInRotatedSortedArray2();
        boolean search = searchInRotatedSortedArray2.search(nums, 1);
        System.out.println(search);
    }
}
