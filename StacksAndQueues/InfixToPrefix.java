package StacksAndQueues;
import java.util.*;
public class InfixToPrefix {
	//Steps to convert infix to prefix 
	// 1. reverse the given expression
	// 2. convert infix exp to postfix exp
	// 3. re-reverse the expression.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="(A+B)*C-D+F";
		Stack<Character> st=new Stack<>();
		
		char[] chars=s.toCharArray();
		int n=s.length();
		for(int i=0;i<n/2;i++) {
			char temp=chars[i];
			chars[i]=chars[n-1-i];
			chars[n-1-i]=temp;
		}
		
		String revstr=new String(chars);
		revstr=revstr.replace('(', '#');
		revstr=revstr.replace(')', '(');
		revstr=revstr.replace('#', ')');
		System.out.println(revstr);
		String ans="";
		for(int i=0;i<revstr.length();i++) {
			char c=revstr.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				ans+=c;
			}else if(c=='(') {
				st.push(c);
			}else if(c==')') {
				while(!st.isEmpty() && st.peek()!='(') {
					ans+=st.pop();
				}
				if(!st.isEmpty()) {
					st.pop();
				}
			}else {
				if(c=='^') { //this check is to ensure of double precedent operator should not come side by side.
					while(!st.isEmpty() && precedence(c)<precedence(st.peek())) {
						ans+=st.pop();
					}
				}else {
					while(!st.isEmpty() && precedence(c)<=precedence(st.peek())) {
						ans+=st.pop();
					}
				}
				st.push(c);
			}
		}
		while(!st.isEmpty()) {
			ans+=st.pop();
		}
		char[] anschars=ans.toCharArray();
		int m=anschars.length;
		for(int i=0;i<m/2;i++) {
			char temp=anschars[i];
			anschars[i]=anschars[m-1-i];
			anschars[m-1-i]=temp;
		}
		String result=new String(anschars);
		System.out.println(result);
	}
	public static int precedence(char ch) {
		switch(ch) {
		case '^':return 3;
		case '*':
		case '/':return 2;
		case '+':
		case '-':return 1;
		}
		return -1;
	}

}
