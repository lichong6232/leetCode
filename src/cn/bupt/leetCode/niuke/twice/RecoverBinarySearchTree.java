package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:47 2019/6/1
 */
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        if (root == null){
            return;
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

    }
    TreeNode firstNode,secondNode,preNode;
    private void findMistake(TreeNode root){
        if (root!=null){
            findMistake(root.left);
            int value = root.val;
            if (preNode != null && preNode.val > value){
                if (firstNode == null){
                    firstNode = preNode;
                    secondNode = root;
                }else {
                    secondNode = root;
                }
            }
            preNode = root;
            findMistake(root.right);

        }
    }

}
