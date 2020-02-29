package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:35 2019/8/6
 */
public class PermutationSequence {

    /**
     * The set [1,2,3,...,n] contains a total of n! unique permutations.

     By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     Given n and k, return the kth permutation sequence.

     Note:

     Given n will be between 1 and 9 inclusive.
     Given k will be between 1 and n! inclusive.
     Example 1:

     Input: n = 3, k = 3
     Output: "213"
     Example 2:

     Input: n = 4, k = 9
     Output: "2314"
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int total =1;
        for (int i=1;i<=n;i++){
            total*=i;
        }
        boolean tag[] = new boolean[n];
        StringBuilder result = new StringBuilder(n);
        while (n>0){
            total = total/n;
            int numth = (k-1)/total+1;
            int num=1;
            for (int i=0;i<tag.length;i++){
                if (tag[i]){
                    continue;
                }
                if (num == numth){
                    result.append(i+1);
                    tag[i] = true;
                    break;
                }
                num++;
            }
            k = (k-1)%total+1;
            n--;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        String permutation = permutationSequence.getPermutation(3, 1);
        System.out.println(permutation);
    }

}
