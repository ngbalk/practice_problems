package practice_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxChoiceFromList {
	static Integer[][] myDPGraph;
	
	public static Integer findMaxScore(List<Integer> input){
		int nothing = 0;
		int first = 1;
		int second = 2;
		int dpRow = 0;
		if(input.size()%2!=0){
			input.add(0);
		}
		Integer[][] dpGraph = new Integer[3][input.size()/2 + 1];
		dpGraph[0][dpRow] = 0;
		dpGraph[1][dpRow] = 0;
		dpGraph[2][dpRow] = 0;
		dpRow++;
		for(int i = 0; i<input.size(); i+=2){
			dpGraph[nothing][dpRow] = getMax(dpGraph[nothing][dpRow-1], dpGraph[first][dpRow-1], dpGraph[second][dpRow-1]);
			dpGraph[first][dpRow] = getMax(dpGraph[nothing][dpRow-1] + input.get(i), dpGraph[first][dpRow-1] + input.get(i));
			dpGraph[second][dpRow] = getMax(dpGraph[nothing][dpRow-1] + input.get(i+1), dpGraph[first][dpRow-1] + input.get(i+1), dpGraph[second][dpRow-1] + input.get(i+1));
			dpRow++;
		}
		printArray(dpGraph);
		return getMax(dpGraph[nothing][input.size()/2], dpGraph[first][input.size()/2], dpGraph[second][input.size()/2]);
	}
	public static Integer getMax(Integer ... args){
		Integer max = 0;
		for(Integer i : args){
			max = (i>max?i:max);
		}
		return max;
	}
	public static void printArray(Integer[][] dpGraph){
		for(int i = 0; i < dpGraph[0].length ; i++){
			for(int j = 0; j<dpGraph.length;j++){
				System.out.print(dpGraph[j][i] + " ");
			}
			System.out.println();
		}
	}
	


	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(10, 10, 10, 10, 40, 100));
		System.out.println(MaxChoiceFromList.findMaxScore(input));
	}
	

}
