package StacksAndQueues;

import java.util.Stack;

public class PostfixToPrefix {

	public static void main(String[] args) {
		Stack<String> st=new Stack<>();
		String s="AB-DE+F*/";  //Postfix Expression
		int i=0;
		while(i<s.length()) {
			char c=s.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				String dup=new String("");
				dup=dup+c;
				st.push(dup);
			}else {
				String t1=st.pop();
				String t2=st.pop();
				String res=c+t2+t1;
				st.push(res);
			}
			i++;
		}
		System.out.println(st.peek());  //Prefix Expression would be /-AB*+DEF

	}

}
