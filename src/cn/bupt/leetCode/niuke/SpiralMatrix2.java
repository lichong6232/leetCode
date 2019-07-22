package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:55 2019/3/29
 */
public class SpiralMatrix2 {


    /**
     * 问题描述：
     * Given an integer n, generate a square matrix filled with elements from 1 to n 2 in spiral order.

     For example,
     Given n =3,

     You should return the following matrix:
     [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
     ]

     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {

        int result[][] = new int[n][n];
        int rowStart = 0,rowEnd = n-1, colStart=0,colEnd=n-1;
        int count = 1;
        while (count<=n*n){
            for (int i = colStart;i<=colEnd;i++){
                result[rowStart][i] = count++;
            }
            rowStart ++;
            for (int i = rowStart;i<= rowEnd;i++){
                result[i][colEnd] = count++;
            }
            colEnd--;
            for (int i= colEnd;i>=colStart;i--){
                result[rowEnd][i] = count++;
            }
            rowEnd--;
            for (int i = rowEnd;i>=rowStart;i--){
                result[i][colStart] = count++;
            }
            colStart++;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
        int[][] ints = spiralMatrix2.generateMatrix(5);
        out(ints);
    }

    private static void out(int a[][]){
        for (int i=0;i<a.length;i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
