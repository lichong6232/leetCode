package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:35 2019/8/10
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int carry = 0;
        int ai = a.length()-1,bi=b.length()-1;
        StringBuffer result = new StringBuffer();
        while (ai>=0 && bi>=0){
            int a1 = a.charAt(ai) - '0';
            int b1 = b.charAt(bi) - '0';
            result.insert(0,(a1+b1+carry)%2);
            carry = (a1+b1+carry)/2;
            ai--;
            bi--;
        }
        while (ai>=0){
            int a1 = a.charAt(ai) - '0';
            result.insert(0,(a1+carry)%2);
            carry = (a1+carry)/2;
            ai--;
        }
        while (bi>=0){
            int b1 = b.charAt(bi) - '0';
            result.insert(0,(b1+carry)%2);
            carry = (b1+carry)/2;
            bi--;
        }
        if (carry>0){
            result.insert(0,carry);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "1",b="111";
        String s = addBinary.addBinary(a, b);
        System.out.println(s);
    }


}
