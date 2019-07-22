package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:11 2019/6/2
 */
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] A, int target) {
        int left = 0,right = A.length;

        while (left<=right){
            int mid = (left+right)/2;
            if (A[mid] == target){
                return true;
            }
            if (A[mid] == A[left] && A[right] == A[mid]){
                for (int i=left;i<=right;i++){
                    if (A[i] == target){
                        return true;
                    }
                }
                return false;
            }else if (A[right]>=A[mid]){
                if (target>A[mid] && target<=A[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }else if (A[mid]>=A[left]){
                if (target>=A[left] && target<A[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        return false;

    }
}
