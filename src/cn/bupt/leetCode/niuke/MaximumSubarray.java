package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:03 2019/4/2
 */
public class MaximumSubarray {


    /**
     *问题描述：
     *
     Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

     For example, given the array[−2,1,−3,4,−1,2,1,−5,4],
     the contiguous subarray[4,−1,2,1]has the largest sum =6.

     click to show more practice.

     More practice:
     If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * @param A
     * @return
     */
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE,sum = 0;
        for (int a : A){
            sum+=a;
            max=Math.max(max,sum);
            if (sum<0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();

        int i = maximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(i);
    }

}
