package cn.bupt.leetCode.core;

import org.omg.PortableServer.POA;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:05 2019/6/22
 */
public class ReverseInteger {


    public int reverse(int x) {
        int result = 0;
        while (x!=0){
            int pos = x%10;
            x/=10;
            if (result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && pos >7)){
                return 0;
            }else if (result<Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && pos<-8)){
                return 0;
            }
            result = 10*result+pos;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE/10;
        System.out.println(i*10);
        System.out.println(Integer.MAX_VALUE);
    }
}
