package cn.bupt.leetCode.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:24 2019/10/8
 */
public class LengthOfLongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        Map<String,Integer> longest = new HashMap<>();
        Map<Integer,Integer> index = new HashMap<>();
        for (int i=0;i<A.length;i++){
            index.put(A[i],i);
        }
        int max = 0;
        for (int i=2;i<n;i++){
            for (int j =i-1;j>0;j--){
                int k =index.getOrDefault(A[i]-A[j],-1);
                if (k>=0 && k<j){
                    String tag = k+"#"+j;
                    int l = longest.getOrDefault(tag,2)+1;
                    max = Math.max(l,max);
                    longest.put(j+"#"+i,l);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = new LengthOfLongestFibonacciSubsequence();
        int A[] = new int[]{1,2,3,4,5,6,7,8};
        int i = lengthOfLongestFibonacciSubsequence.lenLongestFibSubseq(A);
        System.out.println(i);
    }
}
