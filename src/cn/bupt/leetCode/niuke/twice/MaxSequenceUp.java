package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:10 2019/6/3
 */
public class MaxSequenceUp {

    public int getMax(int num[]){
        int max = Integer.MIN_VALUE,sum = 0;
        for (int i = 0;i<num.length;i++){
            sum+=num[i];
            if (sum<0){
                sum = 0;
            }else{
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSequenceUp maxSequenceUp = new MaxSequenceUp();
        int num[] = new int[]{1,2,4,-5};
        int max = maxSequenceUp.getMax(num);
        System.out.println(max);
    }
}
