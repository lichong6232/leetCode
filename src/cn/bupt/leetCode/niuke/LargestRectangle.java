package cn.bupt.leetCode.niuke;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 上午9:12 2019/2/1
 */
public class LargestRectangle {


    /**
     * 问题描述
     * 直方图是由排列在同一基线上的一系列矩形组成的多边形。
     * 为了简单起见，假设这些矩形的宽度相等但高度可能不同。
     * 例如，给出了一个直方图，其中各个矩形的高度为3、2、5、6、1、4、4，宽度为标准1单位。
     * 当给定了一个保存所有矩形高度的数组时，如何找到其中最大的矩形。
     * @param hight
     * @return
     */
    /**
     * 方法1，栈空间
     * @param height
     * @return
     */
    public int largestRectangle(int height[]){
        if (height.length == 0){
            return 0;
        }
        int largest = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<height.length;i++){

            while (!stack.isEmpty() && height[i]<height[stack.peek()]){
                int h = height[stack.pop()];
                largest = Math.max(largest,(i-1-(stack.isEmpty()?-1:stack.peek()))*h);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int h = height[stack.pop()];
            largest = Math.max(largest,h*(stack.isEmpty()?height.length:height.length-stack.peek()-1));
        }
        return largest;
    }


    //利用左右连续递增序列
    public int largestRectangle1(int hight[]){
        int leftSeq[] = new int[hight.length];
        int rightSeq[] = new int[hight.length];

        int maxArea = 0;
        for (int i=0;i<hight.length;i++){
            int leftIndex = i;
            int rightIndex = i;
            //求左增序列，从当前第i个位置往左走，如果前面的元素大于i个位置上的元素，继续往前走，直到左边最后一个大于i个元素的位置
            while (leftIndex>=0 && hight[leftIndex]>=hight[i]){
                leftSeq[i] = leftIndex;
                leftIndex--;
            }
            //求右增序列，从当前第i个位置往右走，如果前面的元素大于i个位置上的元素，继续往前走，直到右边最后一个大于i个元素的位置
            while (rightIndex<hight.length && hight[rightIndex]>=hight[i]){
                rightSeq[i] = rightIndex;
                rightIndex++;
            }

        }
        for (int i=0;i<hight.length;i++){
            int tempArea = (rightSeq[i] - leftSeq[i] +1)*hight[i];
            if (tempArea > maxArea){
                maxArea = tempArea;
            }
        }
        return maxArea;
    }





    public static void main(String[] args) {
        int hight[] = {5,4,1,2};
        LargestRectangle largestRectangle = new LargestRectangle();
        int maxArea = largestRectangle.largestRectangle(hight);
        System.out.println(maxArea);
    }

}
