package practice_problems;

import java.util.Arrays;
import java.util.List;

public class MaxSubarray {
	
	public static Integer findMaxSubarray(List<Integer> input){
		Integer maxSoFar = 0;
		Integer currentMax = 0;
		for(Integer i : input){
			currentMax = Integer.max(i, currentMax + i);
			maxSoFar = Integer.max(currentMax, maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		List<Integer> input = Arrays.asList(1, 2, 3, -100, 5, 7, 20, -15, -1, 20, -1, 20, -11);
		System.out.println(MaxSubarray.findMaxSubarray(input));
	}

}
