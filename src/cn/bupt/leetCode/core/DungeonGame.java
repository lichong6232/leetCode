package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午7:09 2019/8/7
 */
public class DungeonGame {

    /**
     * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

     The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

     Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

     In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.



     Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

     For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

     -2 -3	3
     -5	-10	1
     10	30	-5


     Note:

     The knight's health has no upper bound.
     Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int rowNum = dungeon.length,colNum = dungeon[0].length;
        int dp[][] = new int[rowNum+1][colNum+1];
        for (int i=0;i<=rowNum;i++){
            dp[i][colNum] = Integer.MAX_VALUE;
        }
        for (int j=0;j<=colNum;j++){
            dp[rowNum][j] = Integer.MAX_VALUE;
        }
        dp[rowNum][colNum-1] = 1;
        dp[rowNum-1][colNum] = 1;
        for (int i=rowNum-1;i>=0;i--){
            for (int j=colNum-1;j>=0;j--){
                dp[i][j] = Math.max(1,Math.min(dp[i][j+1],dp[i+1][j]) - dungeon[i][j]);
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        int dungeon[][] = new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        DungeonGame dungeonGame = new DungeonGame();
        int minimumHP = dungeonGame.calculateMinimumHP(dungeon);
        System.out.println(minimumHP);
    }
}
