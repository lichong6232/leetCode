package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:15 2019/1/27
 */
public class MergeSortedArray {


    /**
     * 题目说明
     *Given two sorted integer arrays A and B, merge B into A as one sorted array.

     Note:
     You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        int index = 0;
        for (int i=0;i<n;i++){
            while (index<m){
                if (B[i]<A[index]){
                    for (int k=m-1;k>=index;k--){
                        A[k+1]=A[k];
                    }
                    m++;
                    break;
                }
                index++;
            }
            A[index++] = B[i];
        }

    }

    public void merge1(int A[],int m, int B[], int n){
        int index = m+n-1;
        int i= m-1,j=n-1;
        while (i>=0 && j>=0){
            A[index--] = A[i]>B[j]?A[i--]:B[j--];
        }
        while (i>=0){
            A[index--] = A[i--];
        }
        while (j>=0){
            A[index--] = B[j--];
        }
    }



    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int A[] = {2,5,7,9,10,11,15,18,20,22,23,24,25,28,30,32,35,37,39,40,44,45,50,55,60,77,80,82,88,90,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,00,0,0,0,0,00,0,0,0,0,0,0,0,0,0,0,0,0};
        int B[] = {1,5,8,10,13,14,15,16,20,24,29,30,32,35,38,39,44,48,50,51,52,53,55,59,62,65,66,67,70};
        int m = 29,n=29;
        long startTime = System.nanoTime();
        mergeSortedArray.merge1(A,m,B,n);
        System.out.println("时间"+(System.nanoTime() - startTime));
        for (int i=0;i<m+n;i++){
            System.out.println(A[i]);
        }
    }
}
