package cn.bupt.leetCode.niuke.twice;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:48 2019/6/2
 */
public class DecodeWays {

    /**
     * A message containing letters fromA-Zis being encoded to numbers using the following mapping:

     'A' -> 1
     'B' -> 2
     ...
     'Z' -> 26
     Given an encoded message containing digits, determine the total number of ways to decode it.

     For example,
     Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).

     The number of ways decoding"12"is 2.


     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=s.length();i++){
            if (s.charAt(i-1)!='0'){
                dp[i] = dp[i-1];
            }
            if (s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1) <='6')){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }


    public int numDecodings1(String s) {

        numDecoe(s,0);
        return sum;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        int num = decodeWays.numDecodings1("12");
        System.out.println(num);

    }

    int sum=0;
    private void numDecoe(String s,int start){
        if (start == s.length()){
            sum++;
            return;
        }
        for (int i=start;i<=start+1 && i<s.length();i++){
            if (check(s,start,i)){
                numDecoe(s,i+1);
            }
        }
    }

    private boolean check(String s,int left ,int right){
        char leftChar = s.charAt(left);
        if (left == right){
            return  leftChar >='1' && leftChar<='9';
        }
        char rightChar = s.charAt(right);
        if (leftChar == '1'){
            return rightChar>='0' && rightChar<='9';
        }
        if (left == '2'){
            return rightChar>='0' && rightChar<='6';
        }
        return true;
    }
}
