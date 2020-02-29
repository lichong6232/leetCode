package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:25 2019/10/25
 */

/**
 * 题目：https://blog.csdn.net/liewen_/article/details/83150781
 */
public class TheNumOfAbsolute {

    public int getAbsoluteNum(int nums[]){
        int left =0,right = nums.length-1;
        int ans = 0;
        while (left<=right){
            int num1 = Math.abs(nums[left]);
            int num2 = Math.abs(nums[right]);
            if (num1>num2){
                left++;
                ans++;
                while (left<=right && nums[left]==num1){
                    left++;
                }
            }else if (num1<num2){
                right--;
                ans++;
                while (left<=right && nums[right] == num2){
                    right--;
                }
            }else {
                left++;
                right--;
                ans++;
                while (left<=right && nums[left]==num1){
                    left++;
                }
                while (left<=right && nums[right] == num2){
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TheNumOfAbsolute theNumOfAbsolute = new TheNumOfAbsolute();
        int nums[] = new int[]{-1,0,1,2,3};
        int absoluteNum = theNumOfAbsolute.getAbsoluteNum(nums);
        System.out.println(absoluteNum);
    }
}
