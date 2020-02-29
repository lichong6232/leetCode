package cn.bupt.leetCode.core;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:39 2019/8/7
 */
public class NumberOfIslands {


    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

     Example 1:

     Input:
     11110
     11010
     11000
     00000

     Output: 1
     Example 2:

     Input:
     11000
     11000
     00100
     00011

     Output: 3
     * @param grid
     * @return
     */
    int count =0;
    public int numIslands(char[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        int rowNum = grid.length,colNum = grid[0].length;
        count = rowNum*colNum;
        int father[] = new int[count];
        for (int i=0;i<father.length;i++){
            father[i] = i;
        }

        for (int i=0;i<rowNum;i++){
            for (int j=0;j<colNum;j++){
                if (i<rowNum-1 && grid[i][j] == '1' && grid[i+1][j]=='1'){
                    int x = (i)*colNum + j;
                    int y = (i+1)*colNum +j;

                    union(x,y,father);
                }
                if (j<colNum-1 && grid[i][j] == '1' && grid[i][j+1] =='1'){
                    int x = i*colNum+j;
                    int y = i*colNum+j+1;
                    union(x,y,father);
                }
            }
        }
        return count - oceanNumber(grid);

    }

    public static void main(String[] args) {
        char grid[][] = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int i = numberOfIslands.numIslands(grid);
        System.out.println(i);
    }
    private int findFatherId(int currentId, int father[]){
        if (currentId!=father[currentId]){
            father[currentId] = findFatherId(father[currentId],father);
        }
        return father[currentId];
    }

    private int oceanNumber(char grid[][]){
        int oceanNumber = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='0'){
                    oceanNumber++;
                }
            }
        }
        return oceanNumber;
    }

    private void union(int x,int y,int father[]){
        int xFathId = findFatherId(x,father);
        int yFatherId = findFatherId(y,father);
        if (xFathId == yFatherId){
            return;
        }
        father[xFathId] = yFatherId;
        count--;
    }

    public int numIslands1(char[][] grid) {
        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char grid[][],int row, int col){
        if (row<0 || col<0 || row>=grid.length || col>=grid[0].length
                || grid[row][col] == 'x' || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = 'x';
        dfs(grid,row+1,col);
        dfs(grid,row,col+1);
        dfs(grid,row-1,col);
        dfs(grid,row,col-1);
    }



}
