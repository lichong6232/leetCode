package cn.bupt.leetCode.niuke;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:57 2019/1/23
 */


public class Candies {


    /**
     * 题目描述：There are N children standing in a line. Each child is assigned a rating value.

     You are giving candies to these children subjected to the following requirements:

     Each child must have at least one candy.
     Children with a higher rating get more candies than their neighbors.
     What is the minimum candies you must give?
     * @param ratings 估价集合
     * @return 发放糖果的最小数量
     */
    public static int candy(int[] ratings) {

        int minCandyCount = 0;
        int candys[] = new int[ratings.length];
        Arrays.fill(candys,1);
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1]){
                candys[i] = Math.max(candys[i],candys[i-1]+1);
            }
        }

        for (int j=ratings.length-2;j>=0;j--){
            if (ratings[j]>ratings[j+1]){
                candys[j] = Math.max(candys[j],candys[j+1]+1);
            }
        }
        for (int candyNum : candys){
            minCandyCount += candyNum;
        }
        return minCandyCount;

    }

    public static void main(String[] args) {
        int ratings [] ={1,2,1};
        System.out.println(candy(ratings));
    }
}
