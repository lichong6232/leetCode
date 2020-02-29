package cn.bupt.leetCode.core;

import cn.bupt.leetCode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:51 2019/9/4
 */
public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer,TreeNode> parentMap = new HashMap<>();
        Map<Integer,Integer> deepthMap = new HashMap<>();
        visit(parentMap,deepthMap,root,0);
        return deepthMap.get(x) !=null
                && deepthMap.get(y)!=null
                && deepthMap.get(x).equals(deepthMap.get(y))
                && parentMap.get(x)!=parentMap.get(y);
    }

    private void visit(Map<Integer,TreeNode> parentMap, Map<Integer,Integer> deepthMap,TreeNode root,int level){
        if (root!=null){
            if (root.left!=null){
                parentMap.put(root.left.val,root);
                deepthMap.put(root.left.val,level);
            }
            if (root.right!=null){
                parentMap.put(root.right.val,root);
                deepthMap.put(root.right.val,level);
            }
            visit(parentMap,deepthMap,root.left,level+1);
            visit(parentMap,deepthMap,root.right,level+1);
        }
    }


}
