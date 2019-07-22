package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:51 2019/3/28
 */
public class Sqrtx {

    public int sqrt(int x) {

        long r = x;
        while (r*r > x){
            r = (r+x/r)>>1;
        }
        return (int)r;

    }

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        int sqrt = sqrtx.sqrt(5);
        System.out.println(sqrt);
    }

}
