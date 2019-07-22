package cn.bupt;

import java.nio.file.NotDirectoryException;
import java.util.*;


/**
 * Created by chongli on 2017/8/22.
 */



public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int numbers[] = new int[]{3,2,4};
        int[] ints = test.twoSum(numbers, 6);
        System.out.println(Arrays.toString(ints));
    }

    public int index(int A[], int target){
        int left = 0,right  =A.length-1;
        while (left<=right){
            int mid = (left + right)>>1;
            if (A[mid] == target){
                return mid;
            }
            if (A[mid] == A[left] && A[mid] == A[right]){
                for (int i=left;i<=right;i++){
                    if (A[i] == target){
                        return i;
                    }
                }
                return -1;
            }else if (A[mid] >= A[left]){
                if (target>=A[left] && target<A[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (target<=A[right] && target>A[mid]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }
        for (int i=0;i<numbers.length;i++){
            if (map.containsKey(target-numbers[i])){
                int index1 = i+1;
                int index2 = map.get(target-numbers[i])+1;
                if (index1!=index2){
                    return new int[]{index1<index2?index1:index2,index1<index2?index2:index1};
                }

            }
        }
        return null;
    }

}
