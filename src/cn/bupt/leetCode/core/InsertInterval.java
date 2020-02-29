package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:43 2019/8/6
 */
public class InsertInterval {

    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

     You may assume that the intervals were initially sorted according to their start times.

     Example 1:

     Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     Output: [[1,5],[6,9]]
     Example 2:

     Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     Output: [[1,2],[3,10],[12,16]]
     Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int interval[] = newInterval;
        for (int i=0;i<intervals.length;i++){
            int tempInterval[] = intervals[i];
            if ((tempInterval[0] >=interval[0] && interval[1] >=tempInterval[0])
                    || (interval[0] >= tempInterval[0] && tempInterval[1] >=interval[0])){
                interval[0] = Math.min(interval[0],tempInterval[0]);
                interval[1] = Math.max(interval[1],tempInterval[1]);
            }else {
                if (interval[0]<tempInterval[0]){
                    list.add(interval);
                    interval = tempInterval;
                }else {
                    list.add(tempInterval);
                }

            }
        }
        list.add(interval);
        int result[][] = new int[list.size()][2];
        list.toArray(result);
        return result;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int intervals[][] = new int[][]{{1,5}};
        int newInterval[]=new int[]{0,0};
        int[][] insert = insertInterval.insert(intervals, newInterval);
        for (int i=0;i<insert.length;i++){
            System.out.println(Arrays.toString(insert[i]));
        }
    }
}
