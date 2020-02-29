package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:01 2019/8/8
 */
public class UniqueBinarySearchTrees {


    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

     Example:

     Input: 3
     Output: 5
     Explanation:
     Given n = 3, there are a total of 5 unique BST's:

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        for (int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                dp[i] += (dp[j]*dp[i-j-1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        int numTrees = uniqueBinarySearchTrees.numTrees(3);
        System.out.println(numTrees);
    }
}
