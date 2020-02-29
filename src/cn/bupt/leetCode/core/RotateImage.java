package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:46 2019/8/4
 */
public class RotateImage {

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
        int matrix[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
        for (int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
