package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:35 2019/8/8
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int bitn = 0;
        while (n!=0){
            if ((n&1)==1){
                bitn++;
            }
            n>>>=1;
        }
        return bitn;
    }

    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        numberOf1Bits.hammingWeight(3);
    }
}
