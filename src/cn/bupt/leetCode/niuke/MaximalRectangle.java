package cn.bupt.leetCode.niuke;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:41 2019/1/31
 */
public class MaximalRectangle {

    /**
     * 题目说明
     Given a 2D binary matrix filled with 0's and 1's,
     find the largest rectangle containing all ones and return its area.
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {

        int max = 0;
        for (int i=0;i<matrix.length;i++){
            int tmp[] = new int[matrix[i].length];
            for (int j=0;j<matrix[i].length;j++){
                int k = i;
                while (k>=0 && matrix[k][j] == '1'){
                    tmp[j]++;
                    k--;
                }

            }
            max = Math.max(max,largestRectangle(tmp));

        }

        return max;
    }

    public int largestRectangleArea2(int[] height) {
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

    private int largestRectangle(int hight[]){
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
//        char matrix[][] = {{'0','1'}};
//        MaximalRectangle maximalRectangle = new MaximalRectangle();
//        System.out.println(maximalRectangle.maximalRectangle(matrix));
//        System.out.println(Arrays.toString(maximalRectangle.index(matrix[0])));
//        System.out.println(Arrays.toString(maximalRectangle.index(new char[]{'0','1','1','1','1','0'})));

        int height[] = new int[]{1,8,6,2,5,4,8,3,7};
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        int i = maximalRectangle.largestRectangle(height);
        System.out.println(i);
    }

}
