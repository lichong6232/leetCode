package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午8:00 2019/9/14
 */
public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for (int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int minIndex = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i=0;i<list2.length;i++){

            if (map.containsKey(list2[i]) && map.get(list2[i])+i<=minIndex){
                int indexSum = map.get(list2[i])+i;
                if (indexSum<minIndex){
                    list.clear();
                }
                list.add(list2[i]);
                minIndex = indexSum;
            }
        }
        String ans[] = new String[list.size()];
        for (int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();
        String list1[] = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String list2[] = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] restaurant = minimumIndexSumOfTwoLists.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));
    }
}
