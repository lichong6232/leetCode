package cn.bupt.leetCode.core;

/**
 * @Author: lichong04
 * @Date: Created in 上午12:34 2019/9/14
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters){
            if (c>target){
                return c;
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget findSmallestLetterGreaterThanTarget = new FindSmallestLetterGreaterThanTarget();
        char c[] = new char[]{'c', 'f', 'j'};
        char c1 = findSmallestLetterGreaterThanTarget.nextGreatestLetter(c, 'a');
        System.out.println(c1);

    }
}
