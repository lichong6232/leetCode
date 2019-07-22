package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:53 2019/4/11
 */
public class SearchForARange {

    public int[] searchRange(int[] A, int target) {
        int l1=0,r1=A.length-1,l2=0,r2=A.length-1;
        while (l1<=r1){
            int mid = (l1+r1)>>1;
            if (target>A[mid]){
                l1 = mid+1;
            }else {
                r1 = mid-1;
            }
        }
        while (l2<=r2){
            int mid = (l2+r2)>>1;
            if (target<A[mid]){
                r2 = mid-1;
            }else {
                l2 = mid+1;
            }
        }
        int pos[] = new int[]{-1,-1};
        if (l1<=r2){
            pos[0] = l1;
            pos[1] = r2;
        }
        return pos;
    }

    public static void main(String[] args) {
        SearchForARange searchForARange = new SearchForARange();
        int A[] = new int[]{1};
        int[] ints = searchForARange.searchRange(A, 1);
        System.out.println(Arrays.toString(ints));
    }


}
