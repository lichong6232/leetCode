package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:38 2019/2/6
 */
public class WordSearch {

    /**
     * 问题描述：
     Given a 2D board and a word, find if the word exists in the grid.

     The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

     For example,
     Given board =

     [
     ["ABCE"],
     ["SFCS"],
     ["ADEE"]
     ]
     word ="ABCCED", -> returnstrue,
     word ="SEE", -> returnstrue,
     word ="ABCB", -> returnsfalse.

     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {

        if (board==null || board.length==0 || word == null){
            return false;
        }


        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                boolean tag[][] = new boolean[board.length][board[i].length];
                if (this.search(board,i,j,word,0,tag)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        WordSearch wordSearch = new WordSearch();
        String word = "SEE";
        boolean search = wordSearch.exist(board,word);
        System.out.println(search);
    }

    /**
     * 回溯法
     * @param board
     * @param i
     * @param j
     * @param word
     * @param k
     * @param tag
     * @return
     */
    private boolean search(char[][] board,int i,int j,String word,int k,boolean tag[][]){



        if (i<0 || i>=board.length
                || j<0
                || j>=board[0].length
                || tag[i][j]
                || k == word.length()
                || board[i][j]!=word.charAt(k)
                ){
            return false;
        }

        if (k == word.length()-1){
            return true;
        }
        tag[i][j] = true;
        boolean isFind = search(board,i,j+1,word,k+1,tag) ||
                search(board,i,j-1,word,k+1,tag) ||
                search(board,i+1,j,word,k+1,tag) ||
                search(board,i-1,j,word,k+1,tag);
        tag[i][j] = false;
        return isFind;
    }
}
