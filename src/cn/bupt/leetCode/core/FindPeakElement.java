package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:28 2019/9/17
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,3,5,6,4};
        FindPeakElement findPeakElement = new FindPeakElement();
        int peakElement = findPeakElement.findPeakElement(nums);
        System.out.println(peakElement);
    }

}
