package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:09 2019/6/2
 */
public class GrayCode {


    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n==1){
            result.add(0);
            result.add(1);
            return result;
        }
        ArrayList<Integer> tempList = grayCode(n-1);
        result.addAll(tempList);
        for (int i = tempList.size()-1;i>=0;i--){
            result.add(tempList.get(i) + (int)Math.pow(2,n-1));
        }
        return result;
    }


}
