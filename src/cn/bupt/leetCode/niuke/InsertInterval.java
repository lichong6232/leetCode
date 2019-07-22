package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:45 2019/3/29
 */
public class InsertInterval {

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

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        ArrayList<Interval> result = new ArrayList<>();
        for (;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if (newInterval.start<interval.end){
                break;
            }
            result.add(interval);
        }
        for (;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if ((newInterval.start<=interval.end && newInterval.start>=interval.start)||
                    (newInterval.end>=interval.start && newInterval.end<=interval.end)){
                newInterval = new Interval(Math.min(newInterval.start,interval.start),
                        Math.max(newInterval.end,interval.end));
            }else {
                break;
            }
        }
        result.add(newInterval);
        for (;i<intervals.size();i++){
            result.add(intervals.get(i));
        }
        return result;

    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1,5);
        Interval interval2 = new Interval(5,7);
        Interval interval3 = new Interval(6,7);
        Interval interval4 = new Interval(8,10);
        Interval interval5 = new Interval(12,16);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(interval1);
        list.add(interval2);
//        list.add(interval3);
//        list.add(interval4);
//        list.add(interval5);
        InsertInterval insertInterval = new InsertInterval();
        ArrayList<Interval> insert = insertInterval.insert(list, new Interval(1, 7));
        for (Interval interval : insert){
            System.out.println(interval);
        }

    }

}
