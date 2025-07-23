package subsets;

import java.util.ArrayList;

//we are creating the list of sub strings from a given string using recursion.
public class subseq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p="";
		String up="cbbd";
		//subseq(p,up);
		System.out.println(subseqlist(p,up));
	}
	public static void subseq(String p,String up) { // p is processed & up is unprocessed.
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch=up.charAt(0);
		subseq(p+ch,up.substring(1));
		subseq(p,up.substring(1));
	}
	static ArrayList<String> subseqlist(String p,String up) { // p is processed & up is unprocessed.
		if(up.isEmpty()) {
			ArrayList<String> list =new ArrayList<>();
			list.add(p);
			return list;
		}
		char ch=up.charAt(0);
		ArrayList<String> first = subseqlist(p+ch,up.substring(1));
		ArrayList<String> second = subseqlist(p,up.substring(1));
		first.addAll(second);
		return first;
	}

}
