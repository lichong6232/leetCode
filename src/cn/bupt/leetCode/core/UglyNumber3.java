package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:58 2019/10/26
 */
public class UglyNumber3 {

    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = a,right = n*a;
        int lcmab = a*b/gcd(a,b);
        int lcmac = a*c/gcd(a,c);
        int lcmbc = b*c/gcd(b,c);
        int lcmabc= lcmab*c/gcd(lcmab,c);
        while (left<right){
            int mid = left + (right-left)/2;
            int count = mid/a+mid/b+mid/c-mid/lcmab-mid/lcmac-mid/lcmbc+mid/lcmabc;
            if (count<n){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    private int gcd(int p,int q){
        if (p==0){
            return q;
        }
        return gcd(q%p,p);
    }

    public static void main(String[] args) {
        UglyNumber3 uglyNumber3 = new UglyNumber3();
        int i = uglyNumber3.nthUglyNumber(5, 2, 11, 13);
        System.out.println(i);
    }
}
