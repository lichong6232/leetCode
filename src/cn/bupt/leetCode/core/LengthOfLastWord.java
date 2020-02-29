package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:12 2019/8/6
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int index = s.length()-1;

        for (;index>=0;index--){
            if (s.charAt(index)!=' '){
                break;
            }
        }
        int i=index;
        for (;i>=0;i--){
            if (s.charAt(i) == ' '){
                break;
            }
        }
        return index - i;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int lastWord = lengthOfLastWord.lengthOfLastWord("abc aa");
        System.out.println(lastWord);
    }
}
