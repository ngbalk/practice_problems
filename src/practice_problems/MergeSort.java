package practice_problems;

import java.util.ArrayList;

public class MergeSort {
	
	public static ArrayList<Integer> sort(ArrayList<Integer> list){
		int length = list.size();
		if(length == 1){
			return list;
		}
		return merge(sort(cut(list, 0, list.size()/2 - 1)), sort(cut(list, list.size() / 2, list.size() - 1)));
	}
	public static ArrayList<Integer> cut(ArrayList<Integer> list, Integer begin, Integer end){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for(int i = begin; i<=end; i ++){
				ret.add(list.get(i));
		}
		return ret;
	}
	public static ArrayList<Integer> doSort(ArrayList<Integer> toSort){
		return sort(toSort);
	}
	
	
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int aInd = 0;
		int bInd = 0;
		while(aInd<=a.size() && bInd<=b.size()){
			if(aInd==a.size()){
				ret.addAll(bInd, b);
				break;
			}
			else if(bInd==b.size()){
				ret.addAll(aInd, a);
				break;
			}
			else if(a.get(aInd) <= b.get(bInd)){
				ret.add(a.get(aInd));
				aInd ++;
				continue;
			}
			else if(b.get(bInd) <= a.get(aInd)){
				ret.add(b.get(bInd));
				bInd ++;
				continue;
				
			}
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
