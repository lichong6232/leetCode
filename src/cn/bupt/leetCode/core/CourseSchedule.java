package cn.bupt.leetCode.core;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:46 2019/10/26
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        for (int pre[] : prerequisites){
            indegree[pre[0]] +=1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<indegree.length;i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        int count=0;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            count++;
            for (int pre[] : prerequisites){
                if (pre[1] == poll){
                    indegree[pre[0]]--;
                    if (indegree[pre[0]]==0){
                        queue.add(pre[0]);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int prerequisites[][] = new int[][]{{0,2},{1,2},{2,0}};
        boolean b = courseSchedule.canFinish(3, prerequisites);
        System.out.println(b);
    }
}
