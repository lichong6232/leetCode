package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午12:56 2019/1/27
 */
public class DecodeWays {

    /**
     * 题目描述：
     A message containing letters fromA-Zis being encoded to numbers using the following mapping:

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


    /**
     * 动态规划的方法
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int sLength = s.length();
        if (sLength==0 || s.charAt(0)=='0'){
            return 0;
        }
        int dp[] = new int[sLength+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=sLength;i++){
            if (s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
            if (s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<='6')){
                dp[i]+=dp[i-2];
            }
        }
        return dp[sLength];

    }



    private int num;
    //回溯法，算法复杂度较高
    public int numDecodings1(String s) {
        char[] chars = s.toCharArray();
        if (chars.length==0){
            return num;
        }
        int place[] = new int[chars.length];
        place(place,0,chars);
        place(place,1,chars);
        return num;
    }



    private void place(int[] place,int n,char[] chars){
        if (n==chars.length){
            return;
        }
        int preIndex = -1;
        for (int i=n-1;i>=0;i--){
            if (place[i]==1){
                preIndex = i;
                break;
            }
        }
        if (check(preIndex,n,chars)){
            place[n] = 1;
            if (n==chars.length-1){
                num++;
//                out(place,chars);
            }else {
                place(place,n+1,chars);
                place(place,n+2,chars);
            }
            place[n]=0;
        }
    }

   private void out(int[] place,char chars[]){
        StringBuffer stringBuffer = new StringBuffer();
        int preIndex=-1;
        for (int i=0;i<place.length;i++){
            if (place[i]==1){
                String s = String.valueOf(chars, preIndex + 1, i - preIndex);
                stringBuffer.append(s);
                stringBuffer.append(",");
                preIndex = i;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
       System.out.println(stringBuffer.toString());
   }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        long startTime = System.currentTimeMillis();
        int numDecodings = decodeWays.numDecodings("1111111111111111111111111112222222");
        System.out.println("时间"+(System.currentTimeMillis()-startTime));
        System.out.println(numDecodings);
    }

    private boolean check(int preIndex,int index,char[] chars){
        int charLength = index - preIndex;
        if (charLength>1 && chars[preIndex+1]=='0'){
            return false;
        }
        String nums = String.valueOf(chars,preIndex+1,charLength);
        int  number = Integer.parseInt(nums);
        if (number == 0 || number>26){
            return false;
        }
        return true;

    }
}
