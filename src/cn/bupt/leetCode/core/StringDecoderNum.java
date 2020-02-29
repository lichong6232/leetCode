package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:00 2019/10/26
 */
public class StringDecoderNum {

    int ans=0;
    public int decoderNum(String s){
        backTrace(s,0);
        return ans;
    }

    public static void main(String[] args) {
        StringDecoderNum stringDecoderNum = new StringDecoderNum();
        String s = "1234";
        int i = stringDecoderNum.decoderNum(s);
        System.out.println(i);
    }

    private void backTrace(String s,int start){
        if (start == s.length()){
            ans++;
            return;
        }
        backTrace(s,start+1);
        if (check(s,start,start+1)){
            backTrace(s,start+2);
        }

    }

    private boolean check(String s,int left,int right){

        if (right>=s.length()){
            return false;
        }
        if (s.charAt(left) == '0'){
            return false;
        }
        if (s.charAt(left)>'2'){
            return false;
        }
        if (s.charAt(left) =='2' && s.charAt(right)>'5'){
            return false;
        }
        return true;


    }


}
