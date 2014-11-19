package practice_problems;

public class IsNumber {
	public static boolean isStringNumber(String str){
		return str.matches("[+-]?[0-9]*\\.?[0-9]*");
	}
	public static void main(String[] args) {
		String str = "12.53423";
		System.out.println(IsNumber.isStringNumber(str));

	}

}
