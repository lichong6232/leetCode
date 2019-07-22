package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:15 2019/4/29
 */
public class ReverseInteger {


    public int reverse(int x) {

        int res = 0;
        while (x!=0){
            int tail = x%10;
            int tmp = res*10+tail;
            if ((tmp-tail)/10!=res){
                return 0;
            }
            res = tmp;
            x =x/10;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int reverse = reverseInteger.reverse(1234);
        System.out.println(reverse);
    }

}
