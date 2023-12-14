package student_managment;

public class Grade implements GradeCalculator{
	
	public void calcfinalgrade(AllStudent s) {
		float moy ,sumcoef = 0;
		  
		  for (StudentInfo student : s.list_student.values()) {
			 // Calc For each student .
			  moy = 0;
				  for (ModuleInfo module : student.grades) {
					  	moy += (module.coef * module.mark) ;
					  	sumcoef += module.coef ;
					  	 }
				  student.setfinalgrade( moy / sumcoef );
			   
		   }  
	  }
	
    void displayfinalgrade (AllStudent s , String email) {
		  for (StudentInfo student : s.list_student.values()) {
			 //Display  For each student .
			  if (student.email.equals(email)) {
		  		  System.out.println(student.name + " your final grade is "+
				  			  student.getfinalgrade());
			  }
	       }
	  }


	
	
	
} 

