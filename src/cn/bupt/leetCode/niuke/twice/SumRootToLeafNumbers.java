package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:14 2019/5/31
 */
public class SumRootToLeafNumbers {

    int sumNumber=0;
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return sumNumber;
        }
        dfs(0,root);
        return sumNumber;
    }

    private void dfs(int pre,TreeNode node){
        int currentNumber = 10*pre+node.val;
        if (node.left == null && node.right == null){
            sumNumber += currentNumber;
        }
        if (node.left!=null){
            dfs(currentNumber,node.left);
        }
        if (node.right!=null){
            dfs(currentNumber,node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        int i = sumRootToLeafNumbers.sumNumbers(root);
        System.out.println(i);
    }
}
