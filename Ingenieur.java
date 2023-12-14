package student_managment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Ingenieur extends StudentInfo {
 
	int study_year ;
	String  specialite;
	    
	 Ingenieur(String name,String email ,String department_type,ArrayList <ModuleInfo> initialize_gr ,
			Map <LocalDate,Integer> initialize_att,int study_year,String specialite ) {
		
		super(name,email,department_type,initialize_gr,initialize_att);
			this.study_year  = study_year ;
			this.specialite = specialite ;
	}
	
	void defineing () {
		
		System.out.println("I'm " + this.name + " , I'm the future ingenier in this promo which "
				+ "have " + this.study_year + " student.");
	}
	
	
}
