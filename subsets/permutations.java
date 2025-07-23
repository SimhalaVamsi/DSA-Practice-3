package subsets;
//find the all permutations of a string "abc" =>"abc","acb","cba"etc..
import java.util.ArrayList;

public class permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p="";
		String up="abc";
		ArrayList<String> res=perm(p,up);
		System.out.println(res);
	}
	static ArrayList<String> perm(String p,String up) {
		if(up.isEmpty()) {
			ArrayList<String> list=new ArrayList<>();
			list.add(p);
			return list;
		}
		char ch=up.charAt(0);
		ArrayList<String> ans=new ArrayList<>();
		for(int i=0;i<=p.length();i++) {
			String first = p.substring(0,i);
			String sec = p.substring(i,p.length());
			ans.addAll(perm(first + ch + sec,up.substring(1)));
		}
		return ans;
	}

}
