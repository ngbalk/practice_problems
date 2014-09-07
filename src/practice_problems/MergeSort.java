package practice_problems;

import java.util.ArrayList;

public class MergeSort {
	
	public static ArrayList<Integer> sort(ArrayList<Integer> list){
		int length = list.size();
		if(length == 1){
			return list;
		}
		return merge(sort(cut(list, 0, list.size()/2 - 1)), cut(list, list.size() / 2, list.size()));
	}
	public static ArrayList<Integer> cut(ArrayList<Integer> list, Integer begin, Integer end){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i = 0; i<list.size(); i ++){
			if(i >= begin && i <= end){
				ret.add(list.get(i));
			}
		}
		return ret;
	}
	public static ArrayList<Integer> doSort(ArrayList<Integer> toSort){
		return sort(toSort);
	}
	
	
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if(a.get(0) >= b.get(0)){ 
			
			ret.addAll(b);
			ret.addAll(a);
		}
		else{
			ret.addAll(a);
			ret.addAll(b);
		}
		return ret;
		
	}
	
	public static void main(String[] args){
		Integer[] testData = {5, 24, 2, 1, 55, 12, 14, 12, 31, 9, 100, 26, 83, 3};
		ArrayList<Integer> testArray = new ArrayList<Integer>();
		for(Integer i : testData){
			testArray.add(i);
		}
		System.out.println(doSort(testArray).toString());
	}
}
