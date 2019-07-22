package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 下午9:03 2019/5/4
 */
public class BinaryTreePostorderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root,result);
        return result;
    }
    private void postOrder(TreeNode root,ArrayList<Integer> result){
        if (root!=null){
            postOrder(root.left,result);
            result.add(root.val);
            postOrder(root.right,result);
        }
    }

}
