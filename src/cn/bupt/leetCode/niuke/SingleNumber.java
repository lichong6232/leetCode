package cn.bupt.leetCode.niuke;

public class SingleNumber {
	
	public static void main(String[] args) {
		SingleNumber singleNumber=new SingleNumber();
		int a[]={1,1,2,2,3,3,4};
		int single=singleNumber.singleNumber1(a);
		System.out.println(single);
	}
	
	//����һ����֮����������ȫ�����ֶ���
	 public int singleNumber(int[] A) {
		 int a=0,b=0;
		 for(int c:A){
			 int ta=(~a&b&c)|(a&~b&~c);
			 b=(~a&b&~c)|(~a&~b&c);
			 a=ta;
		 }
		 return b;
	        
	 }
	 //����һ����֮����������ȫ�����ֶ���
	 public int singleNumber1(int A[]){
		 int result=0;
		 for(int a:A){
			 result^=a;
		 }
		 return result;
	 }

}
