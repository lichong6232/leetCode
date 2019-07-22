package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:38 2019/2/24
 */
public class SearchA2DMatrix {


    /**
     * 问题描述：
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:


     Integers in each row are sorted from left to right.
     The first integer of each row is greater than the last integer of the previous row.

     For example,

     Consider the following matrix:

     [
     [1,   3,  5,  7],
     [10, 11, 16, 20],
     [23, 30, 34, 50]
     ]
     Given target =3, returntrue.
     解法1：从右上角开始查找，如果target<当前值，则列变量-1，否则行变量+1
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0,col = matrix[0].length-1;
        while (row <= matrix.length-1 && col>=0){
            if (matrix[row][col] == target){
                return true;
            }else if (target < matrix[row][col]){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {

        int rows = matrix.length,cols = matrix[0].length;
        int begin=0,end=rows*cols-1;
        while (begin<=end){
            int mid = (begin+end)/2;
            int row = mid/cols;
            int col = mid%cols;
            if (matrix[row][col] == target){
                return true;
            }else if (target < matrix[row][col]){
                end = end-1;
            }else{
                begin = begin+1;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int matrix[][]={{1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}};
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        boolean b = searchA2DMatrix.searchMatrix1(matrix, 1);
        System.out.println(b);
    }
}
