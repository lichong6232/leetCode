package cn.bupt.leetCode.niuke.twice;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:49 2019/5/31
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {

        Set<Integer> set = new HashSet<>();
        for (int n : num){
            set.add(n);
        }
        int max = 0;
        for (int n:num){
            if (set.remove(n)){
                int tempSum = 1;
                int value = n;
                int bigValue = value+1;
                int smallValue = value-1;
                while (set.remove(bigValue)){
                    tempSum++;
                    bigValue++;
                }
                while (set.remove(smallValue)){
                    tempSum++;
                    smallValue--;
                }
                max = Math.max(max,tempSum);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int num[] = new int[]{100,4,200,1,3,2};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int max = longestConsecutiveSequence.longestConsecutive(num);
        System.out.println(max);
    }
}
