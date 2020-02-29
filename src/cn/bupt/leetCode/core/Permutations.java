package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 上午1:44 2019/7/29
 */
public class Permutations {



    private List<Integer> toList(int nums[]){
        List<Integer> list = new ArrayList<>();
        for (int num:nums){
            list.add(num);
        }
        return list;
    }

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(toList(nums));
        while (true){
            int i=nums.length-1;
            while (i>0 && nums[i-1]>=nums[i]){
                i--;
            }
            if (i == 0){
                break;
            }
            int leftIndex = i-1,rightIndex = i;
            while (rightIndex<nums.length && nums[rightIndex]>=nums[leftIndex]){
                rightIndex++;
            }
            rightIndex--;
            swap(nums,leftIndex,rightIndex);
            reverse(nums,leftIndex+1,nums.length-1);
            result.add(toList(nums));
        }
        return result;
    }

    private void reverse(int nums[],int start,int end){
        while (start<end){
            swap(nums,start++,end--);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int nums[] = new int[]{1,1,2,2};
        List<List<Integer>> permute = permutations.permute1(nums);
        System.out.println(permute);
    }

    private void swap(int nums[],int i,int j){
        if (i!=j){
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
        }
    }



    //方法2
    public List<List<Integer>> permute1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num:nums){
            temp.add(num);
        }
        dfs(result,temp,new ArrayList<>());
        return result;
    }


    private void dfs(List<List<Integer>> result,List<Integer> remain,List<Integer> pre){
        if (remain.isEmpty()){
            result.add(new ArrayList<>(pre));
        }else {
            for (int i=0;i<remain.size();i++){
                if (i>0 && remain.get(i-1).equals(remain.get(i))){
                    continue;
                }
                Integer removed = remain.remove(i);
                pre.add(removed);
                dfs(result,remain,pre);
                pre.remove(pre.size()-1);
                remain.add(i,removed);
            }
        }

    }




}
