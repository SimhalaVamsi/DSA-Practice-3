package StacksAndQueues;
import java.util.*;
public class InfixToPostfix {
	public static void main(String[] args) {
		Stack<Character> st=new Stack<>();
		String s="a+b*(c^d-e)";
		String ans="";
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch>='a' && ch<='z' ||  //Character.isLetterOrDigit(ch).
			   ch>='A' && ch<='Z' ||
			   ch>='0' && ch<='9') {
				ans+=ch;
			}else if(ch=='(') {
				st.push(ch);
			}else if(ch==')') {
				while(!st.isEmpty() && st.peek()!='(') {
					ans+=st.pop();
				}
				if(!st.isEmpty()) {
					st.pop();
				}
			}else{
				while(!st.isEmpty() && precedence(ch)<=precedence(st.peek())) {
					ans+=st.pop();
				}
				st.push(ch);
			}
		}
		while(!st.isEmpty()) {
			if(st.peek()=='(') {
				System.out.println("Invalid Expression");
			}
			ans+=st.pop();
		}
		System.out.println(ans);
		
	}
	public static int precedence(char ch) {
		switch (ch) {
		case '^': return 3;
		case '*': 
		case '/':return 2;
		case '+':
		case '-': return 1;
		}
		return -1;
	}

}
