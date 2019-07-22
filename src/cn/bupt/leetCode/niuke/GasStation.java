package cn.bupt.leetCode.niuke;

/**
 * Created by chongli on 2017/7/11.
 */
public class GasStation {

    /**
     * 问题描述：There are N gas stations along a circular route, where the amount of gas at station i isgas[i].

     You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

     Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

     Note:
     The solution is guaranteed to be unique.
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length-1;
        int end =0 ;
        int sum = gas[start]-cost[start];
        while (start>end){
            if (sum>0){
                sum+=(gas[end] - cost[end]);
                ++end;
            }else {
                --start;
                sum+=(gas[start] - cost[start]);
            }
        }
        return sum>=0?start:-1;
    }
}
