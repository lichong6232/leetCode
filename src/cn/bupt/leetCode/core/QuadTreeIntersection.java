package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:15 2019/9/4
 */
public class QuadTreeIntersection {

    public Node intersect(Node quadTree1, Node quadTree2) {
        return null;
    }




    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}
