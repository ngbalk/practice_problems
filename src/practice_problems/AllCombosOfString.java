package practice_problems;

import java.util.ArrayList;
import java.util.List;

public class AllCombosOfString {
	
	public static ArrayList<String> strings = new ArrayList<String>();
	
	public static List<String> findAllCombos(String str){
		recurse("", str);
		return strings;
	}
	public static void recurse(String currentStr, String remaining){
		if(remaining == ""){
			return;
		}
		for(int i = 0;i<remaining.length();i++){
			recurse(currentStr+remaining.charAt(i), remove(remaining, i));
			strings.add(currentStr+remaining.charAt(i));
		}
	}
	public static String remove(String string, int index){
		return string.substring(0, index) + string.substring(index+1);
	}

	public static void main(String[] args) {
		System.out.println(AllCombosOfString.findAllCombos("abc"));
		String s = "1.234324";
		System.out.println(s.matches("[-+]?[0-9]*\\.?[0-9]*"));
	}

}
