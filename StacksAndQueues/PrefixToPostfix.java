package StacksAndQueues;

import java.util.Stack;

public class PrefixToPostfix {

	public static void main(String[] args) {
		Stack<String> st=new Stack<>();
		String s="/-AB*+DEF";  //Prefix Expression
		int i=s.length()-1;
		while(i>=0) {
			char c=s.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				String dup=new String("");
				dup=dup+c;
				st.push(dup);
			}else {
				String t1=st.pop();
				String t2=st.pop();
				String res=t1+t2+c;
				st.push(res);
			}
			i--;
		}
		System.out.println(st.peek()); //Postfix Expression would be AB-DE+F*/.

	}

}
