package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:01 2019/2/6
 */
public class SearchInRotatedSortedArray {


    /**
     * 问题描述
     Follow up for "Search in Rotated Sorted Array":
     What if duplicates are allowed?

     Would this affect the run-time complexity? How and why?

     Write a function to determine if a given target is in the array.
     * @param A
     * @param target
     * @return
     * 递归方式
     */
    public boolean search(int[] A, int target) {
        return contains(A,0,A.length-1,target);
    }

    public boolean search1(int[] A,int target){
        int left = 0,right = A.length-1;

        while (left<=right){
            int mid = left + (right - left)/2;
            if (A[mid] == target){
                return true;
            }
            if (A[left] == A[mid] && A[mid] == A[right]){
                for (int i=left;i<=right;i++){
                    if (A[i] == target){
                        return true;
                    }
                }
                return false;
            }else if (A[left]<=A[mid]){
                if (target>=A[left] && target<A[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else if (A[mid]<=A[right]){
                if (target>A[mid] && target<=A[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int A[] = {1,1,3,1};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        boolean search = searchInRotatedSortedArray.search1(A, 3);
        System.out.println(search);

    }


    private boolean contains(int A[],int left, int right, int target){
        int mid = left + (right-left)/2;
        if (A[mid] == target){
            return true;
        }
        if (A[left] == A[mid] && A[mid] == A[right]){
            for (int i=left;i<=right;i++){
                if (A[i] == target){
                    return true;
                }
            }
            return false;
        }else if(A[left]<=A[mid]){
            if (target>=A[left] && target<A[mid]){
                return contains(A,left,mid-1,target);
            }
            return contains(A,mid+1,right,target);
        }else if (A[mid]<=A[right]){
            if (target>=A[mid] && target<=A[right]){
                return contains(A,mid+1,right,target);
            }
            return contains(A,left,mid-1,target);
        }
        return false;
    }
}
