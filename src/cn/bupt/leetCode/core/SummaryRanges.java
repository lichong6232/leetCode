package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:28 2019/9/17
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        int start = 0;
        List<String> list = new ArrayList<>();
        while (start<nums.length){
            if (start == nums.length-1){
                list.add(String.valueOf(nums[start]));
                break;
            }
            int temp = start;
            while (start<nums.length-1 && nums[start]+1 == nums[start+1]){
                start++;
            }
            if (start>temp){
                list.add(String.valueOf(nums[temp])+"->"+String.valueOf(nums[start]));
            }else {
                list.add(String.valueOf(nums[temp]));
            }
            start++;
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,2,4,5,6};
        SummaryRanges summaryRanges = new SummaryRanges();
        List<String> list = summaryRanges.summaryRanges(nums);
        System.out.println(list);
    }
}
