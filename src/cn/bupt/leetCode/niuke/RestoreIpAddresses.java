package cn.bupt.leetCode.niuke;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:26 2019/1/26
 */
public class RestoreIpAddresses {


    /**
     * 题目说明：
     * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

     For example:
     Given"25525511135",

     return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     * @param s
     * @return
     */
    int indexs[] = new int[4];
    public ArrayList<String> restoreIpAddresses(String s) {
        char[] chars = s.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        place(chars,1,result);
        return result;
    }

    public String generateString(char[] chars){
        String s1 = String.valueOf(chars,0,indexs[1]);
        String s2 = String.valueOf(chars,indexs[1],indexs[2]-indexs[1]);
        String s3 = String.valueOf(chars,indexs[2],indexs[3]-indexs[2]);
        String s4 = String.valueOf(chars,indexs[3],chars.length-indexs[3]);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s1);
        stringBuffer.append(".");
        stringBuffer.append(s2);
        stringBuffer.append(".");
        stringBuffer.append(s3);
        stringBuffer.append(".");
        stringBuffer.append(s4);
        return stringBuffer.toString();
    }

    public void place(char[] chars,int n,ArrayList<String> result ){
        for (int i=1;i<=3;i++){
            int tempIndex = indexs[n-1]+i;
            if (check(chars,n,tempIndex)){
                indexs[n]=tempIndex;
                if (n==3){
                    if (chars.length-tempIndex>3){
                        continue;
                    }
                    if (chars.length-tempIndex==0){
                        continue;
                    }
                    if (chars.length-tempIndex>1 && chars[tempIndex]=='0'){
                        continue;
                    }

                    if (Integer.parseInt(String.valueOf(chars,tempIndex,chars.length-tempIndex))>255){
                        continue;
                    }
                    result.add(generateString(chars));
                }else {
                    place(chars,n+1,result);
                }
            }
        }
    }

    public boolean check(char chars[],int index, int charIndex){
        if (charIndex>=chars.length){
            return false;
        }
        int indexBegin = indexs[index-1];
        if (charIndex - indexBegin>1 && chars[indexBegin]=='0'){
            return false;
        }
        int number = Integer.parseInt(String.valueOf(chars, indexBegin, charIndex - indexBegin));
        if (number>255){
            return false;
        }
        return true;

    }




    //第i列的皇后所在的行
    int queueNum=8;
    int cols[] = new int[queueNum];
    int num=0;
    public int get8Queen(){

        placeQueen(0);
        return num;
    }

    /***
     * 尝试放置第n个皇后，在0-queueNum行中寻找合适的位置
     * @param n
     */
    public void placeQueen(int n){
        for (int i=0;i<queueNum;i++){
            if (check(n,i)){
                cols[n]=i;
                if (n==queueNum-1){
                    num++;
                }else {
                    placeQueen(n+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        /*String s = "25525511135";
        String s1 = String.valueOf(s.toCharArray(), 1, 2);
        System.out.println(s1);*/
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        ArrayList<String> strings = restoreIpAddresses.restoreIpAddresses("010010");
        System.out.println(strings);
//        System.out.println(Integer.parseInt("010"));

    }

    /**
     * 放在第n列的第n个皇后，能否放在第n行
     * @param n
     * @param row
     * @return
     */
    public boolean check(int n,int row){

        for (int i=0;i<n;i++){
            //不能和前面的n-1个皇后放在同一行
            if (cols[i]==row){
                return false;
            }
            //不能和前面的n-1个皇后放在/正对角线上
            if (row<cols[i] && i+cols[i]==n+row){
                return false;
            }
            //不能和签名的n-1个皇后放在\反对角线上
            if (row>cols[i] && i-cols[i]==n-row){
                return false;
            }
        }
        return true;

    }


}
