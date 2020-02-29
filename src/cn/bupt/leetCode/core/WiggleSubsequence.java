package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:04 2019/9/26
 */
public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int up[] = new int[n];
        int down[] = new int[n];
        up[0] = down[0] = 1;
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    up[i] = Math.max(up[i],down[j]+1);
                }else if (nums[j]>nums[i]){
                    down[i] = Math.max(down[i],up[j]+1);
                }
            }
        }
        return Math.max(up[n-1],down[n-1]);
    }


    public int wiggleMaxLength1(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int n = nums.length;
        int up=1,down=1;
        for (int i=1;i<n;i++){
            if (nums[i]>nums[i-1]){
                up = down+1;
            }else if (nums[i]<nums[i-1]){
                down = up+1;
            }
        }
        return Math.max(up,down);
    }



    public static void main(String[] args) {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        int nums[] = new int[]{1,17,5,10,13,15,10,5,16,8};
        int i = wiggleSubsequence.wiggleMaxLength1(nums);
        System.out.println(i);
    }


}
