package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:46 2019/9/9
 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0,j=0;
        List<int[]> list = new ArrayList<>();
        while (i<A.length&&j<B.length){
            int aI[] = A[i];
            int bI[] = B[j];
            if (aI[0]>bI[1]){
                j++;
            }else if (bI[0]>aI[1]){
                i++;
            }else {
                int interval[] = new int[2];
                interval[0] = Math.max(aI[0],bI[0]);
                interval[1] = Math.min(aI[1],bI[1]);
                list.add(interval);
                if (aI[1]<bI[1]){
                    i++;
                }else {
                    j++;
                }
            }
        }

        int result[][] = new int[list.size()][2];
        for (int k=0;k<list.size();k++){
            result[k] = list.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        int A[][] = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int B[][] = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] ints = intervalListIntersections.intervalIntersection(A, B);
        for (int i=0;i<ints.length;i++){
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
