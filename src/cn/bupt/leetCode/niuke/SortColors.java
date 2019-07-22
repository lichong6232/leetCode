package cn.bupt.leetCode.niuke;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:21 2019/2/24
 */
public class SortColors {

    public void sortColors(int[] A) {
        int leftIndex=0,rightIndex=A.length-1;
        for (int i=0;i<=rightIndex;){
            if (A[i] == 0){
                int temp =A[leftIndex];
                A[leftIndex] = 0;
                A[i] = temp;
                i++;
                leftIndex++;
            }else if (A[i] == 2){
                int temp = A[rightIndex];
                A[rightIndex] = 2;
                A[i] = temp;
                rightIndex--;
            }else {
                i++;
            }
        }
    }
}
