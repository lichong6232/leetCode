package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:13 2019/8/9
 */
public class FindMinimumInRotatedSortedArray2 {

    public int findMin(int[] nums) {

        int left =0,right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]){
                int min = nums[left];
                while (left<right){
                    min = Math.min(min,nums[left++]);
                }
                return min;
            }
            if (nums[mid]<=nums[right]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return nums[left];

    }

    public static void main(String[] args) {
        int nums[] = new int[]{2,2,2,0,1,2};
        FindMinimumInRotatedSortedArray2 findMinimumInRotatedSortedArray2 = new FindMinimumInRotatedSortedArray2();
        int min = findMinimumInRotatedSortedArray2.findMin(nums);
        System.out.println(min);
    }

}
