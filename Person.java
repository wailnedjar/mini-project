package student_managment;

import java.io.Serializable;

public class Person implements Serializable{
   
	String first_name ,last_name , email , department_type ;
	int age ;
	
	Person (String first_name ,String last_name , int age , String email , String department_type){
		this.last_name = last_name ;
		this.first_name = first_name ; 
		this.email = email ;
		this.department_type = department_type ;
	}
}
