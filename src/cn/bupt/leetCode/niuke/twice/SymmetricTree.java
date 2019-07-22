package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:27 2019/6/1
 */
public class SymmetricTree {

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

     For example, this binary tree is symmetric:

     1
     / \
     2   2
     / \ / \
     3  4 4  3

     But the following is not:

     1
     / \
     2   2
     \   \
     3    3

     Note:
     Bonus points if you could solve it both recursively and iteratively.

     confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return visite(root, root);
    }

    private boolean visite(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if ((node1!=null && node2 == null) || (node1 == null && node2!=null)){
            return false;
        }
        return (node1.val == node2.val) && visite(node1.left,node2.right) && visite(node1.right,node2.left);

    }

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode node1 = new TreeNode(1);
    }


}
