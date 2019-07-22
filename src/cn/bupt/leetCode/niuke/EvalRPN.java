package cn.bupt.leetCode.niuke;

import java.util.Stack;

public class EvalRPN {
	
	
	public static void main(String[] args) {
		String tokens[]={"4", "13", "5", "/", "+"};
		EvalRPN evalRPN=new EvalRPN();
		System.out.println(evalRPN.evalRPN(tokens));
	}
	
	//���쳣���ж�
	public int evalRPN(String[] tokens) {
		if(tokens.length==0)
			return 0;
        Stack<Integer> numbers=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	String temp=tokens[i];
        	try{
        		numbers.add(Integer.parseInt(temp));
        	}catch(Exception e){
        		int number1=numbers.pop();
        		int number2=numbers.pop();
        		switch (temp) {
    			case "+":
    				numbers.add(number2+number1);
    				break;
    			case "-":
    				numbers.add(number2-number1);
    				break;
    			case "*":
    				numbers.add(number2*number1);
    				break;
    			default:
    				numbers.add(number2/number1);
    				break;
    			}
        	}	
        }		
		return numbers.pop();
    }
	
	//һ�㷽��
	 public int evalRPN1(String[] tokens) {
	        if(tokens.length==0)
				return 0;
	        Stack<Integer> numbers=new Stack<Integer>();
	        for(int i=0;i<tokens.length;i++){
	        	String temp=tokens[i];
	        	if(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/")){
	        		char op=temp.charAt(0);
	        		int number1=numbers.pop();
	        		int number2=numbers.pop();
	        		switch (op) {
	    			case '+':
	    				numbers.add(number2+number1);
	    				break;
	    			case '-':
	    				numbers.add(number2-number1);
	    				break;
	    			case '*':
	    				numbers.add(number2*number1);
	    				break;

	    			default:
	    				numbers.add(number2/number1);
	    				break;
	    			}
	        	}else{
	        		numbers.add(Integer.parseInt(temp));
	        	}
	        		
	        }		
			return numbers.pop();
	    }

}
