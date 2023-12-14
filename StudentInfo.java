package student_managment;

import java.util.*;
import java.time.*;

public class StudentInfo extends Person{
	
	public ArrayList<ModuleInfo> grades ;
	public HashMap <LocalDate,Integer> attendance;
	private float finalgrade;
	 
			StudentInfo(String name ,String email , String departemnt_type ,ArrayList <ModuleInfo> grades, Map <LocalDate,Integer> initialize_att  ){
				super(name,email,departemnt_type) ;
			
				this.grades = new ArrayList<> (grades) ;
				this.attendance = new HashMap <> (initialize_att) ;	
			  }	
			
			public void setfinalgrade (float g) {
				 finalgrade = g ;
			  }
			
			public float getfinalgrade () {
				return finalgrade ;
			}  
	}
