package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:05 2019/8/10
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean rowTag0 = false,colTag0 = false;
        for (int i=0;i<matrix.length;i++){
            if (matrix[i][0] == 0){
                colTag0 = true;
                break;
            }
        }

        for (int j=0;j<matrix[0].length;j++){
            if (matrix[0][j]==0){
                rowTag0 = true;
                break;
            }
        }

        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[i].length;j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[i].length;j++){
                if (matrix[i][0] == 0 || matrix[0][j] ==0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowTag0){
            for (int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
        if (colTag0){
            for (int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }


    }
}
