package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:45 2019/8/5
 */
public class MergeIntervals {

    /**
     * Given a collection of intervals, merge all overlapping intervals.

     Example 1:

     Input: [[1,3],[2,6],[8,10],[15,18]]
     Output: [[1,6],[8,10],[15,18]]
     Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     Example 2:

     Input: [[1,4],[4,5]]
     Output: [[1,5]]
     Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length==0){
            return new int[0][0];

        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] interval = intervals[0];
        for (int i=1;i<intervals.length;i++){
            int[] tempInterval = intervals[i];
            if (interval[1]>=tempInterval[0]){
                int newInterval[] = new int[2];
                newInterval[0] = Math.min(interval[0],tempInterval[0]);
                newInterval[1] = Math.max(interval[1],tempInterval[1]);
                interval = newInterval;
            }else {
                list.add(interval);
                interval = tempInterval;
            }
        }
        list.add(interval);
        int[][] result = new int[list.size()][2];
        list.toArray(result);
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals  = new MergeIntervals();
        int nums[][] = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = mergeIntervals.merge(nums);
        for (int i=0;i<merge.length;i++){
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
