package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:55 2019/10/25
 */
public class PermutationN {

    public List<int[]> permutationN(int n){
        List<int[]> res = new ArrayList<>();
        int nums[] = new int[n];
        for (int i=1;i<=n;i++){
            nums[i-1] = i;
        }

        dfs(nums,res,0,n);
        return res;
    }

    private void swap(int nums[],int i,int j){
        if (i!=j){
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
        }
    }

    private void dfs(int nums[],List<int[]> result,int start,int n){
        if (start == n){
            System.out.println(Arrays.toString(nums));
            result.add(Arrays.copyOf(nums,nums.length));
        }else {
            for (int i=start;i<n;i++){
                swap(nums,i,start);
                dfs(nums,result,start+1,n);
                swap(nums,i,start);
            }
        }
    }

    public static void main(String[] args) {
        PermutationN permutationN = new PermutationN();
        List<int[]> list = permutationN.permutationN(4);
        System.out.println(list.size());
        /*for (int[] nums:list){
            System.out.println(Arrays.toString(nums));
        }*/
    }
}
