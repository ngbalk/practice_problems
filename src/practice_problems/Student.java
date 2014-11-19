package practice_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
	private int myId;
	private int myCapacity;
	private int[] myInterval;
	private List<Integer> myClasses;
	public Student(int id, int capacity, int startTime, int endTime){
		myId = id;
		myCapacity = capacity;
		myInterval = new int[2];
		myInterval[0] = startTime;
		myInterval[1] = endTime;
		myClasses = new ArrayList<Integer>();
	}
	public int getId(){
		return myId;
	}
	public int getCapacity(){
		return myCapacity;
	}
	public int[] getInterval(){
		return myInterval;
	}
	public boolean addClass(Integer classId){
		if(!myClasses.contains(classId)){
			myClasses.add(classId);
			myCapacity = myCapacity - 1;
			return true;
		}
		return false;
	}
	public boolean removeClass(Integer classId){
		if(myClasses.contains(classId)){
			myClasses.remove(classId);
			myCapacity = myCapacity + 1;
			return true;
		}
		return false;
	}
	public List<Integer> getClasses(){
		Collections.sort(myClasses);
		return myClasses;
	}
}
