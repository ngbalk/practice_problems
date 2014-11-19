package practice_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Class {
	private int myId;
	private int myCapacity;
	private int myPeriod;
	private List<Integer> myStudents;
	public Class(int id, int capacity, int period){
		myStudents = new ArrayList<Integer>();
		myId = id;
		myCapacity = capacity;
		myPeriod = period;
	}
	public int getId() {
		return myId;
	}
	public int getCapacity() {
		return myCapacity;
	}
	public int getPeriod() {
		return myPeriod;
	}
	public boolean enrollStudent(Integer studentId){
		if(!myStudents.contains(studentId)){
			myStudents.add(studentId);
			myCapacity = myCapacity - 1;
			return true;
			
		}
		return false;
	}
	public boolean removeStudent(Integer studentId){
		if(myStudents.contains(studentId)){
			myStudents.remove(studentId);
			myCapacity = myCapacity + 1;
			return true;
		}
		return false;
	}
	public List<Integer> getStudents(){
		Collections.sort(myStudents);
		return myStudents;
	}


}
