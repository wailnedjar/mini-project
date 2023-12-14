package student_managment;

import java.time.LocalDate;
import java.util.ArrayList ;
import java.util.Map;
import java.util.Scanner;

public class Master extends StudentInfo implements GradeCalculator{
    
	boolean faitstage ;
	String specialite ;

	Master( String name,String email , String department_type, ArrayList<ModuleInfo> initialize_gr, Map<LocalDate, Integer> initialize_att
		   ,boolean faitstage, String specialite){
		
		super(name,email,department_type , initialize_gr, initialize_att);	
		this.faitstage = faitstage ;
		this.specialite = specialite ;
	}
	
	// define master student .
	void definemaster () {
		System.out.println("I'm " + this.name + " ,i study " + this.specialite);
	}

	@Override
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
	
	public String find_internship () {
		Scanner scanner = new Scanner(System.in) ;
		String [] internship  =  {"Data Science" , "Software Enginnier" , "Data analyst" , "Web dev" } ;
		System.out.println("In  which domain you want ?? choice between the available");
		System.out.println(internship);
		
		return scanner.nextLine() ;
		
	}
	
	
	
	
	
}
