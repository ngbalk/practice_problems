package practice_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstDupInteger {
	static Integer[] myList = {1,5,8,3,22,4,7,44,8,7,3,2,22,8,7,12};
	public FirstDupInteger() {		
	}
	public static Integer findFirstDupLinearTime(){
		Map<Integer, Integer> freqs = new HashMap<Integer, Integer>();
		for(Integer i : myList){
			if(!freqs.containsKey(i)){
				freqs.put(i, 1);
			}
			else{
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(findFirstDupLinearTime());

	}
	

}
