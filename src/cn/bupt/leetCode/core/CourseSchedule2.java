package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:14 2019/10/26
 */
public class CourseSchedule2 {


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int res[] = new int[numCourses];
        int count=0;
        int indegree[] = new int[numCourses];
        for (int pre[] : prerequisites){
            indegree[pre[0]] +=1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<indegree.length;i++){
            if (indegree[i] == 0){
                queue.add(i);
                res[count++] = i;
            }
        }

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            for (int pre[] : prerequisites){
                if (pre[1] == poll){
                    indegree[pre[0]]--;
                    if (indegree[pre[0]]==0){
                        queue.add(pre[0]);
                        res[count++] = pre[0];
                    }
                }
            }
        }
        if (count!=numCourses){
            return new int[0];
        }
        return res;
    }

    public static void main(String[] args) {
        CourseSchedule2 courseSchedule2 = new CourseSchedule2();
        int prerequisites[][] = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] order = courseSchedule2.findOrder(4, prerequisites);
        System.out.println(Arrays.toString(order));
    }
}
