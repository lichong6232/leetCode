package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:34 2019/10/3
 */
public class MergeSortedRepeatArray {

    public static int[] merge(int nums1[],int nums2[]){

        int result[] = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while (i<nums1.length&&j<nums2.length){
            if (nums1[i]<nums2[j]){
                result[k++] = nums1[i++];
            }else if (nums1[i]>nums2[j]){
                result[k++] = nums2[j++];
            }else {
                result[k++] = nums1[i++];
                j++;
            }
        }
        while (i<nums1.length){
            result[k++] = nums1[i++];
        }
        while (j<nums2.length){
            result[k++] = nums2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[] = new int[]{1,2,2,2,3,6,7,9};
        int nums2[] = new int[]{0,2,3,3,3,3,3,7,10,14};
        int[] merge = merge(nums1, nums2);
        System.out.println(Arrays.toString(merge));
    }
}
