package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:54 2019/3/30
 */
public class MergeIntervals {

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> res = new ArrayList<>();

        if (intervals.isEmpty()){
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        Interval newInterval = intervals.get(0);
        for (int i=1;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if (newInterval.end>=interval.start){
                newInterval = new Interval(Math.min(newInterval.start,interval.start),
                        Math.max(newInterval.end,interval.end));
            }else {
                res.add(newInterval);
                newInterval = intervals.get(i);
            }
        }
        res.add(newInterval);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(2,3));
        list.add(new Interval(4,5));
        list.add(new Interval(6,7));
        list.add(new Interval(8,9));
        list.add(new Interval(1,10));
        MergeIntervals mergeIntervals = new MergeIntervals();
        ArrayList<Interval> merge = mergeIntervals.merge(list);
        for (Interval interval : merge){
            System.out.println(interval);
        }
    }


}
