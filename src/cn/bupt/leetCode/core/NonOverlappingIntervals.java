package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:50 2019/9/18
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int dp[] = new int[intervals.length];
        dp[0] = 1;
        int ans = 1;
        for (int i=1;i<dp.length;i++){
            int max = 0;
            for (int j=i-1;j>=0;j--){
                if (intervals[j][1]<=intervals[i][0]){
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max+1;
            ans = Math.max(ans,max+1);
        }
        return dp.length - ans;

    }
}
