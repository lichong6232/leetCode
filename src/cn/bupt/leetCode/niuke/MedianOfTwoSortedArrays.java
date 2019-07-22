package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:17 2019/4/30
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        int l = (A.length+B.length+1)/2;
        int r = (A.length+B.length+2)/2;
        return (findKth(A,0,B,0,l)+findKth(A,0,B,0,r))/2.0;
    }

    private int findKth(int A[],int aStart,int B[],int bStart,int k){
        if (aStart>=A.length){
            return B[bStart+k-1];
        }
        if (bStart>=B.length){
            return A[aStart+k-1];
        }
        if (k==1){
            return Math.min(A[aStart],B[bStart]);
        }
        int aIndex = Math.min(A.length-1,aStart+k/2-1);
        int bIndex = Math.min(B.length-1,bStart+k/2-1);
        if (A[aIndex]<B[bIndex]){
            return findKth(A,aIndex+1,B,bStart,k-aIndex+aStart-1);
        }else {
            return findKth(A,aStart,B,bIndex+1,k-bIndex+bStart-1);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int A[] = new int[]{1};
        int B[] = new int[]{2,3,4,5,6};
        double medianSortedArrays = medianOfTwoSortedArrays.findMedianSortedArrays(A, B);
        System.out.println(medianSortedArrays);
    }



}
