package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:46 2019/4/7
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int carry = 0;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int tmp[] = new int[chars1.length+chars2.length];
        for (int i=chars1.length-1;i>=0;i--){
            for (int j = chars2.length-1;j>=0;j--){
                tmp[i+j+1] += (chars1[i]-'0')*(chars2[j]-'0');
            }
        }
        for (int i = tmp.length-1;i>=0;i--){
            tmp[i]+=carry;
            carry = tmp[i]/10;
            tmp[i]%=10;
        }
        StringBuffer result = new StringBuffer();
        int start = 0;
        while (start<tmp.length&&tmp[start]==0){
            start++;
        }
        for (;start<tmp.length;start++){
            result.append(tmp[start]);
        }
        if (result.length() == 0){
            result.append(0);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        String multiply = multiplyStrings.multiply(num1, num2);
        System.out.println(multiply);
    }

}
