package cn.bupt.leetCode;

/**
 * @Author: lichong04
 * @Date: Created in 上午10:56 2019/1/24
 */
public class BstNumber {


    /**
     * 问题描述：Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

     For example,
     Given n = 3, there are a total of 5 unique BST's.

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return numTrees(1,n);

    }

    public int numTrees(int low, int high){
        int num=0;
        if (low>high){
            return num;
        }
        for (int i=low;i<=high;i++){
            int leftTreesNum = numTrees(low,i-1);
            int rightTreesNum = numTrees(i+1,high);
            if (leftTreesNum == 0&& rightTreesNum ==0){
                num+=1;
            } else if (leftTreesNum ==0){
                num+=rightTreesNum;
            }
            else if (rightTreesNum ==0){
                num+=leftTreesNum;
            }else {
                num+=(leftTreesNum*rightTreesNum);
            }

        }
        return num;
    }

    public static void main(String[] args) {
        BstNumber bstNumber = new BstNumber();
        int bstNum = bstNumber.numTrees(2);
        System.out.println(bstNum);
    }

}
