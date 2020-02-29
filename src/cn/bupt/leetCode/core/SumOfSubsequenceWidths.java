package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:44 2019/9/27
 */
public class SumOfSubsequenceWidths {

    public int sumSubseqWidths(int[] A) {
        int MOD = 1_000_000_007;
        Arrays.sort(A);
        dfs(A,0,new ArrayList<>());
        return result;
    }
    int result = 0;
    private void dfs(int nums[], int start, List<Integer> list){
        for (int i=start;i<nums.length;i++){
            list.add(nums[i]);
            result+=(nums[i] - list.get(0));
            dfs(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        /*SumOfSubsequenceWidths sumOfSubsequenceWidths = new SumOfSubsequenceWidths();
        //2,3,3,7
        //[2,3] [2,3,3] [2,3,3,7] [2,3,7][2,7] [3,3][3,3,7] [3,7]
        //1,1,5,5,5,0,4,4
        int nums[] =new int[]{5,69,89,92,31,16,25,45,63,40,16,56,24,40,75,82,40,12,50,62,92,44,67,38,92,22,91,24,26,21,100,42,23,56,64,43,95,76,84,79,89,4,16,94,16,77,92,9,30,13};
        int i = sumOfSubsequenceWidths.sumSubseqWidths(nums);
        System.out.println(i);*/
        int mod=1_0_0_007;
        System.out.println(mod);
    }
}
