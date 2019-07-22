package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:28 2019/6/22
 */
public class MedianOfTwoSortedArrays {


    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.

     Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

     You may assume nums1 and nums2 cannot be both empty.

     Example 1:

     nums1 = [1, 3]
     nums2 = [2]

     The median is 2.0
     Example 2:

     nums1 = [1, 2]
     nums2 = [3, 4]

     The median is (2 + 3)/2 = 2.5
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,n=nums2.length;
        if (m>n){
            int tempArray[] = nums1;
            nums1 = nums2;
            nums2 = tempArray;
            int temp = m;
            m = n;
            n = temp;
        }
        int iLeft = 0,iRight = m,halfLen = (m+n+1)/2;
        while (iLeft<=iRight){
            int i = (iLeft+iRight)/2;
            int j = halfLen - i;
            if (i<iRight && nums2[j-1]>nums1[i]){
                iLeft = i+1;
            }else if (i>iLeft && nums1[i-1]>nums2[j]){
                iRight = i-1;
            }else {
                int leftMax = 0;
                if (i ==0){
                    leftMax = nums2[j-1];
                }else if (j == 0){
                    leftMax = nums1[i-1];
                }else {
                    leftMax = Math.max(nums1[i-1],nums2[j-1]);
                }
                if ((m+n)%2==1){
                    return leftMax;
                }
                int rightMin = 0;
                if (i == m){
                    rightMin = nums2[j];
                }else if (j == n){
                    rightMin = nums1[i];
                }else {
                    rightMin = Math.min(nums1[i],nums2[j]);
                }
                return (leftMax+rightMin)/2.0;
            }
        }
        return 0;
    }

}
