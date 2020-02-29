package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:15 2019/9/13
 */
public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums2.length-1;i++){
            for (int j=i+1;j<nums2.length;j++){
                if (nums2[j]>nums2[i]){
                    map.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }
        for (int i=0;i<nums1.length;i++){
            ans[i] = map.getOrDefault(nums1[i],-1);
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElement1 nextGreaterElement1 = new NextGreaterElement1();
        int nums1[] = new int[]{4,1,2};
        int nums2[] = new int[]{1,3,4,2};
        int[] ints = nextGreaterElement1.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
