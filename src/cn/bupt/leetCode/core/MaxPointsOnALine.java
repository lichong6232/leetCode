package cn.bupt.leetCode.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:56 2019/8/7
 */
public class MaxPointsOnALine {

    /**
     * 参考思路：https://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {

        if (points.length<2){
            return points.length;
        }

        int max = 0;
        for (int i=0;i<points.length-1;i++){
            Map<String,Integer> map = new HashMap<>();
            int overlap=0,lineMax= 0;
            for (int j=i+1;j<points.length;j++){
                int dx = points[i][0]-points[j][0];
                int dy = points[i][1]-points[j][1];
                if (dx == 0 && dy ==0){
                    overlap++;
                    continue;
                }
                int gcd = gcd(dx,dy);
                String key = dx/gcd + "#" + dy/gcd;
                Integer count = map.getOrDefault(key, 0);
                count++;
                map.put(key,count);
                lineMax = Math.max(lineMax,count);
            }
            max = Math.max(max,lineMax+overlap+1);
        }
        return max;
    }

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }

    public static void main(String[] args) {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int points[][] = new int[][]{{1,1},{2,2},{3,3}};
        int maxPoints = maxPointsOnALine.maxPoints(points);
        System.out.println(maxPoints);
    }
}
