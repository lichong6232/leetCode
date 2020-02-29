package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:31 2019/8/5
 */
public class JumpGame {

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     Example 1:

     Input: [2,3,1,1,4]
     Output: true
     Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     Example 2:

     Input: [3,2,1,0,4]
     Output: false
     Explanation: You will always arrive at index 3 no matter what. Its maximum
     jump length is 0, which makes it impossible to reach the last index.
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int furest=0;
        for (int i=0;i<=furest && i<nums.length;i++){
            furest = Math.max(furest,i+nums[i]);
        }
        return furest>=nums.length-1;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3,2,1,0,4};
        JumpGame jumpGame = new JumpGame();
        boolean b = jumpGame.canJump(nums);
        System.out.println(b);
    }
}
