package cn.bupt.leetCode;

public class IsPalindrome {
	
	public static void main(String[] args) {
		String s="1a2";
		IsPalindrome isPalindrome=new IsPalindrome();
		System.out.println(isPalindrome.isPalindrome(s));
	}
	
	
	
	public boolean isPalindrome(String s) {
		if(s==null){
			return false;
		}
		if("".equals(s)){
			return true;
		}
        int left=0,right=s.length()-1;
        while(left<right){
        	while(left<right&&!isAlphanumeric(s.charAt(left))){
        		left++;
        	}
        	while(left<right&&!isAlphanumeric(s.charAt(right))){
        		right--;
        	}
        	if(s.charAt(left)!=s.charAt(right) && Math.abs(s.charAt(left)-s.charAt(right))!=Math.abs('a'-'A')){
        		return false;
        	}
        	left++;
    		right--;
        }
        return true;
    }
	
	public boolean isAlphanumeric(Character c){
		if(c>='a'&&c<='z' || c>='A'&&c<='Z' || c>='0'&&c<='9'){
			return true;
		}
		return false;
	}

}
