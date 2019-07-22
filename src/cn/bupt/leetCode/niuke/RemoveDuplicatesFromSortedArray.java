package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:28 2019/2/6
 */
public class RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int A[] = {1,1,1,2,2,3};
        int count = removeDuplicatesFromSortedArray.removeDuplicates(A);
        System.out.println(Arrays.toString(A));
        System.out.println(count);
    }

    /**
     * 问题描述：
     Follow up for "Remove Duplicates":
     What if duplicates are allowed at most twice?

     For example,
     Given sorted array A =[1,1,1,2,2,3],

     Your function should return length =5, and A is now[1,1,2,2,3].
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {
        int duplicateCount = 2;
        if (A.length<=2){
            return A.length;
        }
        int index = duplicateCount;
        int count = duplicateCount;
        for (int i=duplicateCount;i<A.length;i++){
            if (A[i]!=A[index-duplicateCount]){
                A[index++] = A[i];
                count++;
            }
        }
        return count;
    }
}
