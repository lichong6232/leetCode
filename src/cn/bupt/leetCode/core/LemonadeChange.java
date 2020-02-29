package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:54 2019/10/26
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for (int bill : bills){
            if (bill == 5){
                five++;
            }else if (bill==10){
                if (five == 0){
                    return false;
                }
                ten++;
                five--;
            }else {
                if (ten>0 && five>0){
                    ten--;
                    five--;
                }else if (five>=3){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;

    }
}
