package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:49 2019/9/15
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        if (n<=0){
            return Collections.singletonList(0);
        }
        if (n==1){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> grayCodes = grayCode(n - 1);
        int size = grayCodes.size();
        for (int i=size-1;i>=0;i--){
            grayCodes.add((int) (grayCodes.get(i)+Math.pow(2,n-1)));
        }
        return grayCodes;
    }



    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        List<Integer> gc = grayCode.grayCode(3);
        System.out.println(gc);
    }




}
