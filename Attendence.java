package student_managment;

import java.time.LocalDate;

public class Attendence {
		
	void attendencepercentage (AllStudent s) {
		
	  for (StudentInfo student :s.list_student.values()) {
			// For each student 
			float percentage = 0 ;
		 for(int b:student.attendance.values()) {
				percentage += b ;  
		  }
		  System.out.println("The percentage of attendence of the student " +
			student.name +" is " + (percentage/student.attendance.size()) * 100 + " % in this semester .");	 
		  }	
	  
	 }// end of method .
	static String[] studentexclue (AllStudent s) {
		String []st = new String[100] ;
		int i = 0 ;
		  for (StudentInfo student :s.list_student.values()) {
				// For each student 
			float percentage = 0 ;
			  for(int b:student.attendance.values()) {
					percentage += b ; 
					
			  }
			   if (((percentage/student.attendance.size()) * 100)  < 50) {
				     st[i] = student.name ;
				     i++ ;
			   }
				 
			  }
		  
		  return st;
			
	}
	void displayattendance(AllStudent s,String email_name) {
		String pre_abs ;
		
		  for (StudentInfo student :s.list_student.values()) {
				// For each student
			if(student.email.equals(email_name)) {
			      System.out.println("\n" + student.name + " this is the present list of you ");
					 for(LocalDate key:student.attendance.keySet()) {
								  pre_abs = (student.attendance.get(key) == 0)  ? "Absent": "Present" ;
							 		System.out.println(key + " ---> " + pre_abs); 
					  }    
				   }
		      }	
		 
	      }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
