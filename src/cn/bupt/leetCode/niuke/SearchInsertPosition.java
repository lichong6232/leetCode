package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:44 2019/4/11
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {


        int left = 0,right = A.length-1;
        while (left<=right){
            int mid = (left+right)>>1;
            if (A[mid]==target){
                return mid;
            }else if (target>A[mid]){
                left = mid+1;

            }else {
                right = mid-1;

            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int A[] = new int[]{1,3,5,6};
        int target = 5;
        int i = searchInsertPosition.searchInsert(A, target);
        System.out.println(i);
    }

}
