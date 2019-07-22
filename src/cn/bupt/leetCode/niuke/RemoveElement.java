package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:40 2019/4/19
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int n = A.length;
        for (int i=0;i<n;i++){
            if (A[i] == elem){
                while (n>i&&A[--n] == elem);
                A[i] = A[n];
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int A[] = new int[]{1,1,3,4,5,6,9,0,1,2,1,1,3,6,7};
        out(A,removeElement.removeElement(A,1));
    }

    private static void out(int A[],int n){
        for (int i=0;i<n;i++){
            System.out.println(A[i]);
        }
    }
}
