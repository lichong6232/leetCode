package cn.bupt.leetCode.niuke;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:07 2019/3/31
 */
public class JumpGame {

    /**
     * 问题描述：
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.

     Each element in the array represents your maximum jump length at that position.

     Determine if you are able to reach the last index.

     For example:
     A =[2,3,1,1,4], returntrue.

     A =[3,2,1,0,4], returnfalse.
     * @param A
     * @return
     */
    public boolean canJump(int[] A) {
        int maxReach = 0;
        for (int i=0;i<A.length && i<=maxReach;i++){
            maxReach = Math.max(maxReach,i+A[i]);
        }
        return maxReach>=A.length-1;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        boolean b = jumpGame.canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(b);
    }
}
