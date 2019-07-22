package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:39 2019/4/20
 */
public class RemoveDuplicatesFromSortedArray1 {


    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     For example,
     Given input array A =[1,1,2],

     Your function should return length =2, and A is now[1,2].
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {
        if (A.length<=1){
            return A.length;
        }
        int j=1;
        for (int i=1;i<A.length;i++){
            if (A[i]!=A[j-1]){
                A[j++] = A[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray1 removeDuplicatesFromSortedArray1 = new RemoveDuplicatesFromSortedArray1();
        int A[] = new int[]{3,3,3,3,5,5,5,5,5,8,8,8,13,13,13,13};
        int i = removeDuplicatesFromSortedArray1.removeDuplicates(A);
        System.out.println(i);
        out(A,i);
    }

    private static void out(int A[],int num){
        for (int i=0;i<num;i++){
            System.out.println(A[i]);
        }
    }
}
