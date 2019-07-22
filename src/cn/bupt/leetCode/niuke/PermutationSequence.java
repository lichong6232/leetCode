package cn.bupt.leetCode.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:13 2019/3/28
 */
public class PermutationSequence {


    /**
     * 问题描述：
     *
     *
     The set[1,2,3,…,n]contains a total of n! unique permutations.

     By listing and labeling all of the permutations in order,
     We get the following sequence (ie, for n = 3):

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"

     Given n and k, return the k th permutation sequence.

     Note: Given n will be between 1 and 9 inclusive.
     *
     */

    //算法复杂度过高，未通过
    int n=1;
    public String getPermutation1(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            list.add(i);
        }
        return permutation(list,"",k);
    }

    /**
     * 实现思路：
     * 根据数据全排列的排列方式，n个数可以组成的排列数有n!种，如果要找到排在第k位置的数，
     * 可以先定位到第一个数字
     * 由于以每个数字开头的数字都有(n-1)!种，所以第一个数字的位置是(k-1)/(n-1)!+1的位置。
     * 找到第一个数字的位置之后，接下来的问题就转换为了在余下的n-1个数的全排序中找到第(k-1)%(n-1)!+1的数。
     * 整个问题就是个递归问题，一直到n=0结束
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n,int k){
        int total = 1;
        for (int i=1;i<=n;i++){
            total*=i;
        }
        StringBuffer result = new StringBuffer();
        boolean tag [] = new boolean[n];
        while (n>0){
            total = total/n;
            int numberIndex = (k-1)/total+1;

            int num =1;
            for (int i=0;i<tag.length;i++){
                if (tag[i]){
                    continue;
                }
                if (num == numberIndex){
                    result.append(i+1);
                    tag[i]=true;
                }
                num++;
            }
            k = (k-1)%total+1;
            n--;

        }
        return result.toString();
    }

    public String getPermutationByRecursion(int n,int k){
        return permutationByRecursion(n,k,new boolean[n],"");
    }

    private String permutationByRecursion(int n,int k,boolean tag[],String s){
        if (n==0){
            return s;
        }
        int total = 1;
        for (int i=1;i<n;i++){
            total *= i;
        }
        int index = (k-1)/total+1;
        int num =1;
        for (int i=1;i<=tag.length;i++){
            if (tag[i-1]){
                continue;
            }
            if (num == index){
                s += i;
                tag[i-1] = true;
            }
            num++;
        }
        int nextK = (k-1)%total+1;
        return permutationByRecursion(n-1,nextK,tag,s);
    }



    /*private String permutation(int n,int k,boolean tag[],String result){

    }*/

    private String permutation(List<Integer> words, String s,int k){
        if (words.isEmpty()){
            if (n == k){
                return s;
            }
            n++;
        }
        for (int i=0;i<words.size();i++){
            Integer removed = words.remove(i);
            String tempS = s+removed;
            String permutation = permutation(words, tempS, k);
            if (permutation!=null){
                return permutation;
            }
            words.add(i,removed);

        }
        return null;
    }

    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i=0;i<list.size();i++){
            Integer remove = list.remove(i);
            System.out.println(remove);
            list.add(i,remove);
        }*/
        PermutationSequence permutationSequence = new PermutationSequence();
        String permutation = permutationSequence.getPermutation(3, 3);
        System.out.println(permutation);
    }
}
