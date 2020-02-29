package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:21 2019/9/25
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        String reverse = reverse(s);
        String newString = s+"#"+reverse;
        int preSuff[] = new int[newString.length()];
        preSuff[0]=0;
        for (int i=1;i<preSuff.length;i++){
            int t = preSuff[i-1];
            while (t>0 && newString.charAt(t)!=newString.charAt(i)){
                t = preSuff[t-1];
            }
            if (newString.charAt(t) == newString.charAt(i)){
                t++;
            }
            preSuff[i] = t;
        }

        return reverse.substring(0,reverse.length()-preSuff[preSuff.length-1])+s;
    }

    private String reverse(String s){
        char revsese[] = s.toCharArray();
        int left =0,right = s.length()-1;
        while (left<right){
            revsese[left] = (char) (revsese[left]^revsese[right]);
            revsese[right] = (char) (revsese[left]^revsese[right]);
            revsese[left] = (char) (revsese[left]^revsese[right]);
            left++;
            right--;
        }
        return String.valueOf(revsese);
    }

    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        String sp = shortestPalindrome.shortestPalindrome("");
        System.out.println(sp);
    }
}
