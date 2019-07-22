package cn.bupt.leetCode.niuke.twice;

import java.util.ArrayList;

/**
 * @Author: lichong04
 * @Date: Created in 上午9:36 2019/6/2
 */
public class RestoreIpAddresses {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        dfs(0,result,s,"");
        return result;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        ArrayList<String> list = restoreIpAddresses.restoreIpAddresses("25525511135");
        System.out.println(list);
    }

    private void dfs(int n,ArrayList<String> result,String s,String pre){
        if (n==3 && check(s)){
            result.add(pre + s);
        }else {
            for (int i=1;i<=3 && i<s.length();i++){
                String tempS = s.substring(0,i);
                if (check(tempS)){
                    dfs(n+1,result,s.substring(i),pre + tempS+".");
                }
            }
        }

    }

    private boolean check(String s){
        if (s.length()>1 && s.charAt(0) == '0'){
            return false;
        }
        if (s.length()>3){
            return false;
        }
        int num = Integer.parseInt(s);
        return num<=255;
    }

}
