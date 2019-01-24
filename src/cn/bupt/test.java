package cn.bupt;

import java.nio.file.NotDirectoryException;
import java.util.List;

/**
 * Created by chongli on 2017/8/22.
 */

class Node{

    Node next;
    Node pre;

    Node(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int x;
    public int y;
}

public class test {

    public static void main(String args[]){
        Node node1=new Node(1,2);
        Node node2=new Node(5,3);
        Node node3=new Node(4,6);
        Node node4=new Node(7,5);
        Node node5=new Node(9,0);


    }

    public static void getNode(List<Node> nodeList,Node root){
        Node node=root;

    }


   /* public static int getLIS(Node[] Nodes, int n) {
        // write code here
        if (Nodes==null||n==0)
            return 0;
        int dp[]=new int[n];
        dp[0]=1;
        int res=1;
        for(int i=1;i<n;i++){
            int temMax=0;
            for (int j=0;j<i;j++){
                if (Nodes[i].x>Nodes[j].x || Nodes[i].y>Nodes[j].y){
                    temMax=Math.max(temMax,dp[j]);
                }
            }
            dp[i]=temMax+1;
            if (res<dp[i]){
                res=dp[i];
            }
        }
        return res;
    }*/
}
