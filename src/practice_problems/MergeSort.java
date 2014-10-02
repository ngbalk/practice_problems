package practice_problems;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	/**
	 * Writing divideAndConquer to implement a mergeSort.  divideAndConquer is a recursive method.  Only requires 4 lines of code.  
	 * call conquer which takes two parameters, each of which will only return when the list is of length 1, then it returns and we start to pop
	 * back up the stack.
	 * @param list
	 * @return
	 */
	
	public static List<Integer> divideAndConquer(List<Integer> list){
		System.out.println(list.toString());
		if(list.size()==1){
			return list;
		}
		return conquer(divideAndConquer(list.subList(0, list.size()%2 == 0 ? list.size()/2 : list.size()/2 + 1)), divideAndConquer(list.subList(list.size()%2 == 0 ? list.size()/2 : list.size()/2 + 1, list.size())));

		
		

	}
	public static List<Integer> conquer(List<Integer> a, List<Integer> b){
		List<Integer> ret = new ArrayList<Integer>();
		int aInd=0;
		int bInd=0;
		while(true){
			if(aInd==a.size()){
				ret.addAll(b.subList(bInd, b.size()));
				break;
			}
			if(bInd==b.size()){
				ret.addAll(a.subList(aInd, a.size()));
				break;
			}
			if(a.get(aInd)<=b.get(bInd)){
				ret.add(a.get(aInd));
				aInd++;
			}
			else{
				ret.add(b.get(bInd));
				bInd++;
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
		System.out.println(divideAndConquer(testArray).toString());
	}
}
