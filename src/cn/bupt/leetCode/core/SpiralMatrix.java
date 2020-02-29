package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:54 2019/8/5
 */
public class SpiralMatrix {

    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

     Example 1:

     Input:
     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     Output: [1,2,3,6,9,8,7,4,5]
     Example 2:

     Input:
     [
     [1, 2, 3, 4],
     [5, 6, 7, 8],
     [9,10,11,12]
     ]
     Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0){
            return list;
        }
        int rowNum = matrix.length,colNum = matrix[0].length;
        int leftCol = 0,rightCol = colNum-1;
        int highRow = rowNum-1,lowRow = 0;

        while (leftCol<=rightCol && lowRow<=highRow){
            for (int j=leftCol;j<=rightCol;j++){
                list.add(matrix[lowRow][j]);
            }
            for (int i=lowRow+1;i<=rowNum-1 && i<=highRow;i++){
                list.add(matrix[i][rightCol]);
            }
            for (int j = rightCol-1;j>=0 && j>=leftCol && lowRow<highRow;j--){
                list.add(matrix[highRow][j]);
            }
            for (int i=highRow-1;i>=0 && i>=lowRow+1 && leftCol<rightCol;i--){
                list.add(matrix[i][leftCol]);
            }
            leftCol++;
            rightCol--;
            lowRow++;
            highRow--;
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int matrix[][] = new int[][]{{1},{2},{3}};
        List<Integer> list = spiralMatrix.spiralOrder(matrix);
        System.out.println(list);
    }
}
