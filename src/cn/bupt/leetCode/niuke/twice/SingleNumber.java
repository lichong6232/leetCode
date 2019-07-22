package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:06 2019/5/30
 */
public class SingleNumber {

    /**
     * 问题描述：
     * Given an array of integers, every element appears twice except for one. Find that single one.
     Note:
     Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        int result = 0;
        for (int a : A){
            result = a^result;
        }
        return result;
    }

    public static void main(String[] args) {
        int A[] = new int[]{1,4,6,8,1,4,6};
        SingleNumber singleNumber = new SingleNumber();
        int i = singleNumber.singleNumber(A);
//        System.out.println(i);
        System.out.println();
    }
}
