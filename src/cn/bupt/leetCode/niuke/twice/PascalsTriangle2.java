package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:31 2019/6/1
 */
public class PascalsTriangle2 {

    /**
     * 问题描述：
     * Given an index k, return the k th row of the Pascal's triangle.

     For example, given k = 3,
     Return[1,3,3,1].
     Note:
     Could you optimize your algorithm to use only O(k) extra space?
     * @param rowIndex
     * @return
     */
    public ArrayList<Integer> getRow(int rowIndex) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0;i<rowIndex+1;i++){
            result.add(1);
            for (int j=i-1;j>0;j--){
                result.set(j,result.get(j-1) + result.get(j));
            }
        }
        return result;

    }

}
