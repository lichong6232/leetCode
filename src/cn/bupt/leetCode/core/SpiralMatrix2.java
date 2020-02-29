package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:21 2019/8/6
 */
public class SpiralMatrix2 {

    /**
     * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

     Example:

     Input: 3
     Output:
     [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
     ]
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int rowStart=0,rowEnd=n-1,colStart=0,colEnd=n-1;
        int num = 1;
        int matrixNum = n*n;
        int matrix[][] = new int[n][n];
        while (num<=matrixNum){
            for (int j=colStart;num<=matrixNum && j<=colEnd;j++){
                matrix[rowStart][j] = num++;
            }
            rowStart++;
            for (int i=rowStart;num<=matrixNum && i<=rowEnd;i++){
                matrix[i][colEnd] = num++;
            }
            colEnd--;
            for (int j=colEnd;num<=matrixNum && j>=colStart;j--){
                matrix[rowEnd][j] = num++;
            }
            rowEnd--;
            for (int i = rowEnd;num<=matrixNum && i>=rowStart;i--){
                matrix[i][colStart] = num++;
            }
            colStart++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        int[][] ints = spiralMatrix2.generateMatrix(3);
        for (int i=0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
