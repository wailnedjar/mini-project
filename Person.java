package student_managment;

import java.io.Serializable;

public class Person implements Serializable{
   
	String name , email , department_type ;
	
	Person (String name , String email , String department_type){
		this.name = name ; 
		this.email = email ;
		this.department_type = department_type ;
	}
}
