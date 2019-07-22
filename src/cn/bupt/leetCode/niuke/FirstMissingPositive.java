package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:39 2019/4/8
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {

        if (A.length == 0){
            return 1;
        }

        for (int i=0;i<A.length;i++){
            while (A[i]>0 && A[i]!=i+1 && A[i]-1 <A.length && A[i]!=A[A[i]-1]){
                swap(A,i,A[i]-1);
            }
        }
        for (int i=0;i<A.length;i++){
            if (A[i]!=i+1){
                return i+1;
            }
        }
        return A[A.length-1]+1;
    }

    private void swap(int[] A,int i,int j){
        if (i!=j){
            A[i] = A[i]^A[j];
            A[j] = A[i]^A[j];
            A[i] = A[i]^A[j];
        }
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int A[] = new int[]{-5,1,1,0};
        int i = firstMissingPositive.firstMissingPositive(A);
        System.out.println(i);

    }
}
