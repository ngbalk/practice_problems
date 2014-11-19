package practice_problems;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	/*
	 * Complete the functions below.
	 */

	public static String addClass(int id, int capacity, int time) {
  // If the class is added successfully, 
  // return "Successfully added class ID". 
  // Otherwise, return "Error adding class ID".
	}
	
	public static String removeClass(int id) {
  //If the class is removed successfully,
  // return "Successfully removed class ID". 
  // Otherwise, return "Error removing class ID".
	}
	
	public static String infoClass(int id) {
  // If the class does not exist, 
  // return "Class ID does not exist". 
  // If the class is empty, 
  // return "Class ID is empty". 
  // Otherwise, return the string 
  // "Class ID has the following students: LIST" 
  // where LIST is a sorted, comma-separated list 
  // of student IDs corresponding to students currently 
  // in the class.
	}
	
	public static String addStudent(int id, int capacity, int start, int end) {
  // If the student is added successfully, 
  // return "Successfully added student ID". 
  // Otherwise, return "Error adding student ID".
	}
	
	public static String removeStudent(int id) {
  // If the student is removed successfully, 
  // return "Successfully removed student ID". 
  // Otherwise, return "Error removing student ID".
	}
	
	public static String infoStudent(int id) {
  // If the student does not exist, 
  // return "Student ID does not exist". 
  // If the student is not taking any classes, 
  // return "Student ID is not taking any classes". 
  // Otherwise, return the string 
  // "Student ID is taking the following classes: LIST" 
  // where LIST is a sorted, comma-separated list of class IDs 
  // corresponding to classes that the student is 
  // currently taking.
	}
	
	public static String enrollStudent(int studentId, int classId) {
  // If enrollment of the student in the class succeeded,
  // return "Number of free spots left in class CLASSID: FREESPOTS" 
  // where FREESPOTS is the number of free spots left 
  // in the class after the student enrolls. 
  // Otherwise, return "Enrollment of student STUDENTID in class CLASSID failed".
	}
	
	public static String unenrollStudent(int studentId, int classId) {
  // If unenrollment of the student in the class succeeded,
  // return "Number of free spots left in class CLASSID: FREESPOTS" 
  // where FREESPOTS is the number of free spots left in the class 
  // after the student unenrolls. Otherwise, return "Unenrollment 
  // of student STUDENTID in class CLASSID failed".
	}

		
    public static String[] processCommands(String[] commands) {
		String[] ret = new String[commands.length];
		for(int i = 0; i < commands.length; i++) {
			StringTokenizer st = new StringTokenizer(commands[i]);
			String op = st.nextToken();
			if(op.equals("ADDCLASS")) {
				int id = Integer.parseInt(st.nextToken());
				int cap = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				ret[i] = addClass(id, cap, time);
			}
			else if(op.equals("REMOVECLASS")) {
				int id = Integer.parseInt(st.nextToken());
				ret[i] = removeClass(id);
			}
			else if(op.equals("INFOCLASS")) {
				int id = Integer.parseInt(st.nextToken());
				ret[i] = infoClass(id);
			}
			else if(op.equals("ADDSTUDENT")) {
				int id = Integer.parseInt(st.nextToken());
				int cap = Integer.parseInt(st.nextToken());
				int timeStart = Integer.parseInt(st.nextToken());
				int timeEnd = Integer.parseInt(st.nextToken());
				ret[i] = addStudent(id, cap, timeStart, timeEnd);
			}
			else if(op.equals("REMOVESTUDENT")) {
				int id = Integer.parseInt(st.nextToken());
				ret[i] = removeStudent(id);
			}
			else if(op.equals("INFOSTUDENT")) {
				int id = Integer.parseInt(st.nextToken());
				ret[i] = infoStudent(id);
			}
			else if(op.equals("ENROLLSTUDENT")) {
				int studentId = Integer.parseInt(st.nextToken());
				int classId = Integer.parseInt(st.nextToken());
				ret[i] = enrollStudent(studentId, classId);
			}
			else if(op.equals("UNENROLLSTUDENT")) {
				int studentId = Integer.parseInt(st.nextToken());
				int classId = Integer.parseInt(st.nextToken());
				ret[i] = unenrollStudent(studentId, classId);
			}
		}
		return ret;
	}

	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        
        int _commands_size = Integer.parseInt(in.nextLine());
        String[] _commands = new String[_commands_size];
        String _commands_item;
        for(int _commands_i = 0; _commands_i < _commands_size; _commands_i++) {
            try {
                _commands_item = in.nextLine();
            } catch (Exception e) {
                _commands_item = null;
            }
            _commands[_commands_i] = _commands_item;
        }
        
        res = processCommands(_commands);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }
}

