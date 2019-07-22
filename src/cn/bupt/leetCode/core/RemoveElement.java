package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:16 2019/6/25
 */
public class RemoveElement {

    /**
     *Given an array nums and a value val, remove all instances of that value in-place and return the new length.

     Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

     The order of elements can be changed. It doesn't matter what you leave beyond the new length.

     Example 1:

     Given nums = [3,2,2,3], val = 3,

     Your function should return length = 2, with the first two elements of nums being 2.

     It doesn't matter what you leave beyond the returned length.
     Example 2:

     Given nums = [0,1,2,2,3,0,4,2], val = 2,

     Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

     Note that the order of those five elements can be arbitrary.

     It doesn't matter what values are set beyond the returned length.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int i=0;
        for (;i<nums.length;i++){
            if (nums[i] == val){
                break;
            }
        }
        for (int j=i+1;j<nums.length;j++){
            if (nums[j] == val){
                continue;
            }
            nums[i++] = nums[j];
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int nums[] = new int[]{0,1,2,2,3,0,4,2,5};
        int length = removeElement.removeElement(nums, 2);
        for (int i=0;i<length;i++){
            System.out.println(nums[i]);
        }
    }
}
