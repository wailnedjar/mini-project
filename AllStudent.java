package student_managment;
import java.util.*;
   // contain an arraylist of student .

public class AllStudent {
      
	// we use hashmap because id is unique to avoid duplicates .
	HashMap<String,StudentInfo> list_student = new HashMap<String,StudentInfo> () ;
	
	public void Add_Student(String id , StudentInfo info){ // We pass info student .
		 this.list_student.put(id, info) ; 
		 
	 }

}
