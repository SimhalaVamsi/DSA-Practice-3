package StacksAndQueues;

import java.util.Stack;

public class MaxSumGame {
	
	public static void main(String[] args) {
		Stack<Integer> f=new Stack<>();
		Stack<Integer> s=new Stack<>();
		//elements in stack 'f'.
		f.push(8);
		f.push(6);
		f.push(4);
		f.push(2);
		f.push(4);
		//elements in stack 's'.
		s.push(8);
		s.push(5);
		s.push(1);
		s.push(2);
		System.out.println(maxSumCount(f,s,0,0,10)-1);

	}
	public static int maxSumCount(Stack<Integer> f,Stack<Integer> s,int sum,int cnt,int maxSum) {
		if(sum>=maxSum) {
			return cnt;
		}
		int max=cnt;
		
		if(!f.isEmpty()) {
			int topF=f.pop();
			int ans1=maxSumCount(f,s,sum+topF,cnt+1,maxSum);
			max=Math.max(max, ans1);
			f.push(topF);
		}
		
		if(!s.isEmpty()) {
			int topS=s.pop();
			int ans2=maxSumCount(f,s,sum+topS,cnt+1,maxSum);
			max=Math.max(max, ans2);
			f.push(topS);
		}	
		
		return max;
	}
	
}
