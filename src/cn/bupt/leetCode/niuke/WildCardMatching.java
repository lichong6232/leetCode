package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:49 2019/4/7
 */
public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        boolean match[][] = new boolean[s.length()+1][p.length()+1];
        if (p.equals("")){
            return s.equals("");
        }
        if (s.equals("")){
            for (int i=0;i<p.length();i++){
                if (p.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        match[0][0] = true;
        for (int i=1;i<=p.length();i++){
            match[0][i] = match[0][i-1]&&p.charAt(i-1) =='*';
        }
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                if (p.charAt(j-1)=='*'){
                    match[i][j] = match[i-1][j] || match[i][j-1];
                }else if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='?'){
                    match[i][j] = match[i-1][j-1];
                }else {
                    match[i][j] = false;
                }
            }
        }
        return match[s.length()][p.length()];
    }

    public static void main(String[] args) {
        WildCardMatching wildCardMatching = new WildCardMatching();
        String s = "c";
        String p = "*?*";
        boolean match = wildCardMatching.isMatch(s, p);
        System.out.println(match);
    }

}
