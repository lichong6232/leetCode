package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:56 2019/3/28
 */
public class AddBinary {


    /**
     * 问题描述：Given two binary strings, return their sum (also a binary string).

     For example,
     a ="11"
     b ="1"
     Return"100".
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder result =  new StringBuilder();
        int i=a.length()-1,j=b.length()-1,carry=0;
        while (i>=0 || j>=0 || carry > 0){
            int sum = carry;
            if (i>=0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >=0){
                sum += b.charAt(j) - '0';
                j--;
            }
            result.append(sum%2);
            carry = sum/2;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s = addBinary.addBinary("11", "1");
        System.out.println(s);
    }
}
