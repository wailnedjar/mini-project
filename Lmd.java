package student_managment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Lmd extends StudentInfo implements GradeCalculator{
    
    int nbsection  ;
	int year_study ;
	
	Lmd(String name, String email,String department_type, ArrayList<ModuleInfo> initialize_gr, Map<LocalDate, Integer> initialize_att
			  ,int year_study , int nbsection) {
		super(name,email,department_type,initialize_gr, initialize_att);
		this.year_study = year_study ;
		this.nbsection = nbsection ;
	}

	@Override // Because Lmd has credit .
	public void calcfinalgrade(AllStudent all, String email) {
		float moy = 0 , sumcoef = 0 ;
		
		for (StudentInfo student :all.list_student.values() ) {			 
			if(student.email.equals(email)) { // if the student is lmd student .
				  for (ModuleInfo module : student.grades) {
					  	moy += (module.coef * module.mark) ;
					  	sumcoef += module.coef ;
					 }
				  student.setfinalgrade( moy / sumcoef  );
				
			  }
	     }
		if (this.getfinalgrade() <= 10) {
			this.setfinalgrade(moy * (1.2f * sumcoef) ) ; // pour le credit .
		}
	  }
	
	
	
	
	
}
