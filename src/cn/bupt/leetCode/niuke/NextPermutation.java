package cn.bupt.leetCode.niuke;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:31 2019/4/17
 */
public class NextPermutation {


    public void nextPermutation(int[] num) {

        int i = num.length-1;
        for (;i>0;i--){
            if (num[i-1]<num[i]){
                break;
            }
        }
        if (i>0){
            int k = i+1;
            while (k<num.length && num[k]>num[i-1]){
                k++;
            }
            k--;
            swap(num,i-1,k);
        }
        reverse(num,i,num.length-1);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int num[] = new int[]{1,1};
        nextPermutation.nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }

    private void reverse(int num[] ,int start,int end){
        while (start<end){
            swap(num,start,end);
            start++;
            end--;
        }
    }

    private void swap(int a[],int i,int j){
        if (i!=j){
            a[i] = a[i]^a[j];
            a[j] = a[i]^a[j];
            a[i] = a[i]^a[j];
        }
    }

}
