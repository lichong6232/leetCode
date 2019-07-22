package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:25 2019/6/1
 */
public class PascalsTriangle {

    /**
     * 问题描述：
     *
     Given numRows, generate the first numRows of Pascal's triangle.

     For example, given numRows = 5,
     Return

     [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     ]

     * @param numRows
     * @return
     */
    public ArrayList<ArrayList<Integer>> generate(int numRows) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i=0;i<numRows;i++){
            ArrayList<Integer> tempResult = new ArrayList<>();
            for (int j=0;j<=i;j++){

                if (j == 0 || j == i){
                    tempResult.add(1);
                }else {
                    tempResult.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                }
            }
            result.add(tempResult);
        }
        return result;
    }

}
