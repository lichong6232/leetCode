package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:27 2019/4/28
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        if (height.length<2){
            return 0;
        }
        int left = 0,right = height.length-1;
        while (left<right){
            int are = Math.min(height[left],height[right]) * (right-left);
            maxArea = Math.max(are,maxArea);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int height[] = new int[]{1,2,4,3};
        int maxArea = containerWithMostWater.maxArea(height);
        System.out.println(maxArea);
    }

}
