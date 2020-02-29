package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:33 2019/7/20
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int step=0,pre=0,curr=0;
        for (int i=0;i<nums.length;i++){
            if (i>pre){
                step++;
                pre = curr;
            }
            curr = Math.max(curr,i+nums[i]);
        }
        return step;

    }

}
