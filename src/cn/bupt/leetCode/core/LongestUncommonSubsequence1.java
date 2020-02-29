package cn.bupt.leetCode.core;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 上午11:58 2019/10/8
 */
public class LongestUncommonSubsequence1 {

    public int findLUSlength(String a, String b) {

        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        String a ="aba";
        String b = "a";
        LongestUncommonSubsequence1 longestUncommonSubsequence1 = new LongestUncommonSubsequence1();
        int luSlength = longestUncommonSubsequence1.findLUSlength(a, b);
        System.out.println(luSlength);

    }


}
