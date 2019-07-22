package cn.bupt.leetCode.niuke.twice;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:31 2019/5/30
 */
public class Candy {

    /**
     * 问题描述：
     * There are N children standing in a line. Each child is assigned a rating value.

     You are giving candies to these children subjected to the following requirements:

     Each child must have at least one candy.
     Children with a higher rating get more candies than their neighbors.
     What is the minimum candies you must give?
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int candys[] = new int[ratings.length];
        for (int i=1;i<candys.length;i++){
            if (ratings[i]>ratings[i-1]){
                candys[i] = Math.max(candys[i],candys[i-1])+1;
            }
        }
        for (int i = candys.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1]){
                candys[i] = Math.max(candys[i],candys[i+1])+1;
            }
        }
        int sum = 0;
        for (int candy : candys){
            sum += candy;
        }
        System.out.println(Arrays.toString(candys));
        return sum+ratings.length;
    }

    public static void main(String[] args) {

        int ratings[] = new int[]{1,3,2,6,9,4,7,10,7,3};
        Candy candy = new Candy();
        int candy1 = candy.candy(ratings);

        System.out.println(candy1);

    }
}
