package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:56 2019/10/26
 */
public class NumberOfSubarraysWithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarry(A,R) - numSubarry(A,L-1);
    }

    private int numSubarry(int A[],int max){
        int res=0,numSubArray = 0;
        for (int a : A){
            if (a<=max){
                numSubArray++;
                res+=numSubArray;
            }else {
                numSubArray=0;
            }
        }
        return res;
    }
}
