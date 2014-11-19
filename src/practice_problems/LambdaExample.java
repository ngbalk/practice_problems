package practice_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaExample {
	List<String> myList = new ArrayList<String>();
	public LambdaExample(){
		myList = new ArrayList<String>();
		myList.add("hello");
		myList.add("my");
		myList.add("name");
		myList.add("is");
		myList.add("Nick");
	}
	public <T> void takeLambda(Consumer<T> func){
		for(String s : myList){
			(s) -> {return func(s);};
		}
	}
	public void printList(){
		for(String s : myList){
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		LambdaExample lambdaExample = new LambdaExample();
		lambdaExample.doSomething();

	}
	public void addZ(String s){
		s=s+"z";
	}
	public void doSomething(){
		this.takeLambda(this::addZ);
		this.printList();
	}

}
