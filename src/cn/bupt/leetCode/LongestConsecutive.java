package cn.bupt.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
	
	 public int longestConsecutive(int[] num) {
		 if(num == null || num.length==0)
			 return 0;
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 int longest =0;
		 for(int i=0;i<num.length;i++){
			 if(!map.containsKey(num[i])){
				 map.put(num[i], 1);
				 if(map.containsKey(num[i]-1)){
					 longest=Math.max(longest, merge(map, num[i]-1, num[i]));
				 }
				 if(map.containsKey(num[i]+1)){
					 longest=Math.max(longest, merge(map, num[i], num[i]+1));
				 }
			 }
		 }
		 return longest;
	 }
	 
	 public int merge(Map<Integer,Integer> map,int less,int more){
		 int left=less-map.get(less)+1;
		 int right=more+map.get(more)-1;
		 int len=right-left+1;
		 map.put(left, len);
		 map.put(right, len);
		 return len;
	 }

}
