package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:10 2019/3/29
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        char c[] = s.toCharArray();
        int count = 0;
        for (int i=c.length-1;i>=0;i--){
            if (c[i]==' '){
                if (count==0){
                    continue;
                }
                break;
            }
            count++;

        }
        return count;

    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s ="a ";
        int i = lengthOfLastWord.lengthOfLastWord(s);
        System.out.println(i);
    }
}
