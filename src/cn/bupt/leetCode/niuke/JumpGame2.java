package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:31 2019/4/6
 */
public class JumpGame2 {

    /**
     * 题目描述：
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Your goal is to reach the last index in the minimum number of jumps.

     For example:
     Given array A =[2,3,1,1,4]

     The minimum number of jumps to reach the last index is2. (Jump1step from index 0 to 1, then3steps to the last index.)

     * @param A
     * @return
     */
    public int jump(int[] A) {

        int step=0,furthestPre=0,furthestCurrent=0;
        for (int i=0;i<A.length;i++){
            if (i>furthestPre){
                step++;
                furthestPre = furthestCurrent;
            }
            furthestCurrent = Math.max(furthestCurrent,i+A[i]);
        }
        return step;
    }
}
