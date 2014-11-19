package practice_problems;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeepList {

	public DeepList() {
		
		
	}
	public static int evalList(String str){
		int totVal = 0;
		int depth = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == '{'){
				depth++;
			}
			if(str.charAt(i) == '}'){
				depth--;
			}
			else{
				totVal+= Integer.parseInt(str.substring(i, i+1));
			}
			
		}
		return totVal;
	}
	
	public static void main(String args[]){
		//DeepList.evalList("{12}");
		ArrayList<String> tester = new ArrayList<String>();
		tester.add("I");
		tester.add("Am");
		tester.add("Awesome");
		String toPrint = tester.stream()
				.collect(Collectors.joining(" "));
		System.out.println(toPrint);
		
		
	}


}

