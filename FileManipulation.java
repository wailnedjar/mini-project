package student_managment;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;



class FileManipulation {

	public static void read(AllStudent all_st) {
		 String name , id ,email,dep;
		 HashMap <LocalDate,Integer> attendance = new HashMap <LocalDate, Integer>();

		try { 
		 BufferedReader read = new BufferedReader (new FileReader("C:\\Users\\asus\\Documents\\project1-files\\student.csv"));
			String line = read.readLine() ;
			
			 while (( line = read.readLine()) != null) {
				 ArrayList  <ModuleInfo> grades = new ArrayList <ModuleInfo> () ;

				 String [] row = line.split(",");
				 int length = row.length;
				 
				 id = row [0] ;
				 name = row[1] ;
				 email = row[2] ;
				 dep = row[3] ;
				 System.out.println(name);
				 grades.add(new ModuleInfo(row[4], Float.parseFloat(row[5]),Integer.parseInt(row[6]) ) )   ;
				 grades.add(new ModuleInfo(row[7], Float.parseFloat(row[8]),Integer.parseInt(row[9]) ) )   ;
				 grades.add(new ModuleInfo(row[10], Float.parseFloat(row[11]),Integer.parseInt(row[12]) ) )   ;
				  
				 for (int i = 13 ; i < length - 1 ; i = i+2 ) {
					 attendance.put(LocalDate.parse(row[i],DateTimeFormatter.ISO_LOCAL_DATE), Integer.parseInt(row[i+1])) ;	 
				 	}		 
			   StudentInfo st = new StudentInfo(name,email,dep, grades, attendance);
			   all_st.Add_Student(id, st); 
			   
			 }
			 read.close();
		} 
		
		catch (IOException e) {
			System.out.println("no file");
		}
	}
	
	/* 
	 * 
	 * -------------------------------------------*/
	
	public static void write (AllStudent all_student) {
		
		try {
			String line ;
			FileWriter write = new FileWriter("C:\\\\Users\\\\asus\\\\Documents\\\\project1-files\\\\student.csv");
			
			String [] id = all_student.list_student.keySet().toArray(new String[all_student.list_student.size()]);
			int nb_keys = 0 ;
			
			write.write("id,name,email,department,module,mark,coef,module,mark,coef,module,mark,coef,date,present/abscent") ;
			write.write("\n") ;
			
			for (StudentInfo st : all_student.list_student.values()) {
				   line  =   id [nb_keys]+ "," + st.name + "," + st.email + "," + st.department_type + ",";
				   nb_keys ++ ;  
				       for (ModuleInfo mo : st.grades) {
				    	   line += mo.module_name + "," + mo.mark + "," +  mo.coef + "," ;
				        }
				       for (Entry<LocalDate, Integer> e : st.attendance.entrySet()) {
				    	   line += e.getKey() + "," + Integer.toString( e.getValue() ) + ",";
				       }
				   write.write(line) ;
				   write.write("\n");
			}
		  write.close();	
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
//		String line = read.append() ;
		
	}
}
