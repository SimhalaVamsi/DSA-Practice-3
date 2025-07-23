package subsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//we are creating the list of sub numbers from a given array of numbers.
public class Numsubseq {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,2,3};
		//List<List<Integer>> ans=subsets(arr);
		List<List<Integer>> ans=subsetDuplicates(arr);
		for(List<Integer> list:ans) {
			System.out.print(list);
		}
	}
	static List<List<Integer>> subsets(int[] arr){
		List<List<Integer>> outer=new ArrayList<>();
		outer.add(new ArrayList<>()); //internally we are intilaising with empty list.(for refernce check your notes)
		for(int num:arr) {
			int n=outer.size(); 
			for(int i=0;i<n;i++) {
				List<Integer> internal= new ArrayList<>(outer.get(i)); //
				internal.add(num);
				outer.add(internal);
			}
		}
		return outer;
	}
	static List<List<Integer>> subsetDuplicates(int[] arr){
		Arrays.sort(arr);
		int start=0;
		int end=0;
		List<List<Integer>> outer=new ArrayList<>();
		outer.add(new ArrayList<>()); //internally we are intilaising with empty list.(for refernce check your notes)
		
		for(int i=0;i<arr.length;i++) {
			start=0;
			if(i>0 && arr[i]==arr[i-1]) {
				start=end+1;
			}
			end=outer.size()-1;
			int n=outer.size(); 
			for(int j=start;j<n;j++) {
				List<Integer> internal= new ArrayList<>(outer.get(j)); // Here we are adding element of outer list of j into the internal list.
				internal.add(arr[i]);
				outer.add(internal); //after adding element just combine the internal list with outer list.
			}
		}
		return outer;
	}

}
