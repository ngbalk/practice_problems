package practice_problems;

import java.util.List;

public class School {
	private List<Class> myClasses;
	private List<Student> myStudents;
	public School(){
		
	}
	public String addClass(Integer id, Integer capacity, Integer period){
		if(!containsClass(id)){
			Class newClass = new Class(id, capacity, period);
			myClasses.add(newClass);
			return "Succesfully added class " + id;
		}
		return "Error adding class " + id;
	}
	public String removeClass(Integer id){
		if(containsClass(id)){
			myClasses.remove(getClassById(id));
			for(Student s : myStudents){
				s.removeClass(id);
			}
			return "Succesfully removed class " + id;
		}
		return "Error removing class " + id; 
	}
	public String addStudent(Integer id, Integer capacity, Integer start, Integer end){
		if(!containsStudent(id)){
			Student newStudent = new Student(id, capacity, start, end);
			myStudents.add(newStudent);
			return "Succesfully added student " + id;
		}
		return "Error adding student " + id;
	}
	public String removeStudent(Integer id){
		if(containsStudent(id)){
			myStudents.remove(getStudentById(id));
			for(Class c : myClasses){
				c.removeStudent(id);
			}
			return "Succesfully removed student " + id;
		}
		return "Error removing student " + id;
	}
	
	public String getStudentInfo(Integer id){
		if(containsStudent(id)){
			if(getStudentById(id).getClasses().isEmpty()){
				return "Student " + id + " is not taking any classes";
			}
			String ret = "Student " + id + " is taking the following classes: ";
			for(Integer classId : getStudentById(id).getClasses()){
				ret += classId + ", ";
			}
			ret = ret.substring(0, ret.length() - 2);
			return ret;
		}
		return "Student " + id + " does not exist"; 
	}

	public String getClassInfo(Integer id){
		if(containsClass(id)){
			if(getClassById(id).getStudents().isEmpty()){
				return "Class " + id + " is empty";
			}
			String ret = "Class " + id + " has the following students: ";
			for(Integer studentId : getClassById(id).getStudents()){
				ret += studentId + ", ";
			}
			ret = ret.substring(0, ret.length() - 2);
			return ret;
		}
		return "Class " + id + " does not exist"; 
	}
	public boolean containsClass(Integer classId){
		for(Class c : myClasses){
			if(c.getId() == classId){
				return true;
			}
		}
		return false;
	}
	public boolean containsStudent(Integer studentId){
		for(Student s : myStudents){
			if(s.getId() == studentId){
				return true;
			}
		}
		return false;
	}
	public Class getClassById(Integer id){
		for(Class c : myClasses){
			if(c.getId()==id){
				return c;
			}
		}
		return null;
	}
	private Student getStudentById(Integer id) {
		for(Student s : myStudents){
			if(s.getId()==id){
				return s;
			}
		}
		return null;
	}
	public String enrollStudentInClass(Integer studentId, Integer classId){
		if(!(containsStudent(studentId) && containsClass(classId))){
			return "Enrollment of student " + studentId + " in " + classId + " failed";
		}
		Student student = getStudentById(studentId);
		Class c = getClassById(classId);
		if(student.getCapacity()==0){
			return "Enrollment of student " + studentId + " in " + classId + " failed";
		}
		if(c.getCapacity()==0){
			return "Enrollment of student " + studentId + " in " + classId + " failed";
		}
		if(c.getPeriod() < student.getInterval()[0] | c.getPeriod() > student.getInterval()[1]){
			return "Enrollment of student " + studentId + " in " + classId + " failed";
		}
		if(student.getClasses().contains(classId)){
			return "Enrollment of student " + studentId + " in " + classId + " failed";
		}
		c.enrollStudent(studentId);
		student.addClass(classId);
		return "Number of free spots left in class " + classId + ": " + c.getCapacity();
	}
	public String removeStudentFromClass(Integer studentId, Integer classId){
		if(!(containsStudent(studentId) && containsClass(classId))){
			return "Unenrollment of student " + studentId + " in " + classId + " failed";
		}
		Student student = getStudentById(studentId);
		Class c = getClassById(classId);
		if(!c.getStudents().contains(classId)){
			return "Unenrollment of student " + studentId + " in " + classId + " failed";
		}
		student.removeClass(classId);
		c.removeStudent(studentId);
		return "Number of free spots left in class " + classId + ": " + c.getCapacity();
	}
}
