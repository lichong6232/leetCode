package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:14 2019/2/27
 */
public class SetMatrixZeroes {

    /**
     * 题目说明：
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

     click to show follow up.

     Follow up:
     Did you use extra space?
     A straight forward solution using O(m n) space is probably a bad idea.
     A simple improvement uses O(m + n) space, but still not the best solution.
     Could you devise a constant space solution?
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rowNum = matrix.length,colNum = matrix[0].length;
        boolean rowTag = false,colTag = false;
        for (int i=0;i<rowNum;i++){
            if (matrix[i][0] == 0){
                colTag = true;
                break;
            }
        }
        for (int j=0;j<colNum;j++){
            if (matrix[0][j] == 0){
                rowTag = true;
                break;
            }
        }
        for (int i=1;i<rowNum;i++){
            for (int j=1;j<colNum;j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j]=0;
                }
            }
        }
        for (int i=1;i<rowNum;i++){
            for (int j=1;j<colNum;j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowTag){
            for (int j = 0;j<colNum;j++){
                matrix[0][j]=0;
            }
        }
        if (colTag){
            for (int i=0;i<rowNum;i++){
                matrix[i][0]=0;
            }
        }
    }
}
