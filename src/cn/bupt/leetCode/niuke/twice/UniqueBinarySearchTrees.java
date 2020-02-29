package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 上午9:12 2019/6/2
 */
public class UniqueBinarySearchTrees {

    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

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
        if (n<=1){
            return 1;
        }
        int sum = 0;
        for (int i=1;i<=n;i++){
            sum += numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        int numTrees = uniqueBinarySearchTrees.numTrees(3);
        System.out.println(numTrees);
    }
}
