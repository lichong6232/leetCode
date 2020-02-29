package cn.bupt.leetCode.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:49 2019/8/26
 */
public class MinimumHeightTrees {

    /**
     * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

     Format
     The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

     You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

     Example 1 :

     Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

     0
     |
     1
     / \
     2   3

     Output: [1]
     Example 2 :

     Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
     \ | /
     3
     |
     4
     |
     5

     Output: [3, 4]
     Note:

     According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
     The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.


     解题思路：
     遍历叶子节点，同时删除叶子节点，删除完叶子节点之后，又会产生一个新的叶子节点，继续遍历新的叶子节点，当最后节点的个数小于等于2的时候截止

     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n==1){
            leaves.add(0);
            return leaves;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i=0;i<n;i++){
            if (adj.get(i).size()==1){
                leaves.add(i);
            }
        }


        while (n>2){
            List<Integer> newLeaves = new ArrayList<>();
            for (int j:leaves){
                int adj_j = adj.get(j).get(0);
                adj.get(adj_j).remove((Integer) j);
                if (adj.get(adj_j).size()==1){
                    newLeaves.add(adj_j);
                }
            }

            n-= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        int n=6;
        int edges[][] = new int[][]{{0,1},{0,2},{0,3},{3,4},{4,5}};
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        List<Integer> minHeightTrees = minimumHeightTrees.findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees);
    }

}
