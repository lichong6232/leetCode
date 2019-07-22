package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:12 2019/3/31
 */
public class SpiralMatrix {

    /**
     * 问题描述：
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

     For example,
     Given the following matrix:

     [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     ]
     You should return[1,2,3,6,9,8,7,4,5].
     * @param matrix
     * @return
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0){
            return res;
        }
        int rowNumber = matrix.length,colNumber = matrix[0].length;
        int rowStart = 0,rowEnd = rowNumber-1,colStar=0,colEnd=colNumber-1;

        while (res.size()<rowNumber*colNumber){
            for (int i=colStar;i<=colEnd&&res.size()<rowNumber*colNumber;i++){
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i= rowStart;i<=rowEnd&&res.size()<rowNumber*colNumber;i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            for (int i=colEnd;i>=colStar&&res.size()<rowNumber*colNumber;i--){
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            for (int i=rowEnd;i>=rowStart&&res.size()<rowNumber*colNumber;i--){
                res.add(matrix[i][colStar]);
            }
            colStar++;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        ArrayList<Integer> integers = spiralMatrix.spiralOrder(new int[][]{{2, 3}});
        System.out.println(integers);
    }
}
