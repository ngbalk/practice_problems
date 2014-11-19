package practice_problems;

import java.util.HashMap;
import java.util.Map;

public class MatchPatterns {
	public static boolean initialize(String pattern, String string){
			for(int i=1;i<string.length();i++){
			
				if(matchPatterns(new HashMap<String, String>(), pattern, string.substring(i), string.substring(0,i))){
				
					return true;
				}
			
			}
			return false;
	}	
	public static boolean matchPatterns(Map<String, String> map, String pattern, String remaining, String toMatch){
		System.out.println(map.toString());
		if(map.containsKey(pattern.substring(0,1)) && map.get(pattern.substring(0,1))!=toMatch){
			return false;
		}
		map.put(pattern.substring(0,1), toMatch);
		pattern = pattern.substring(1);
		if(pattern.isEmpty() ^ remaining.isEmpty()){
			return false;
		}
		for(int i=1;i<remaining.length();i++){
			
			if(matchPatterns(new HashMap<String, String>(map), pattern, remaining.substring(i), remaining.substring(0,i))){
				return true;
			}
			
		}
		return false;

	}
	public static void main(String[] args) {
		
		System.out.println(MatchPatterns.initialize("abba", "redbluebluered"));

	}

}
