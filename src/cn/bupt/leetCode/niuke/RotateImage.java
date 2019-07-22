package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:30 2019/4/6
 */
public class RotateImage {

    /**
     * 题目描述：
     * You are given an n x n 2D matrix representing an image.

     Rotate the image by 90 degrees (clockwise).

     Follow up:
     Could you do this in-place?
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0;i<n/2;i++){
            for (int j=i;j<n-i-1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }

    }
    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int [][] matrix= new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate(matrix);
        out(matrix);
    }
    private static void out(int[][] matrix){
        for (int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
