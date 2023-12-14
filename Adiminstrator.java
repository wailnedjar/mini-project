package student_managment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Adiminstrator extends Person{
      
	  public Adiminstrator(String name, String deparment, String email) {
		super(name,email,deparment) ;
	}

	  
	 /**************************************************************************************/
	  
	public static ArrayList<Adiminstrator> Read_Administator (ArrayList<Adiminstrator> admin) throws IOException{
		  
		  BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\asus\\Documents\\project1-files\\adiminAuthentification.csv")) ;
		  
		  String line = read.readLine() ;
		
		  while (  (line = read.readLine()) != null  ) {
			 String arr [] = new String[3] ;
			 arr = line.split(",") ;
			 String name = arr[0] ;
			 String deparment = arr  [1] ;
			 String email = arr[2] ;
			  
			 admin.add(new Adiminstrator(name,deparment,email)) ;  
		  }
		 return admin ;
	  }
	
	/**************************************************************************************/
	public static void write_teacher(ArrayList<Teacher> teachers) {
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter("C:\\Users\\asus\\Documents\\project1-files\\teacherAutentification.csv"));
		    
			for (Teacher t:teachers) {
				 write.write(t.name + "," + t.department_type + "," + t.email + "," + t.module + "," + t.grade);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**************************************************************************************/
	
	
	public void display_teacher () {
		
		ArrayList<Teacher> teacher = new ArrayList<Teacher>() ;
		teacher = Teacher.Read_Teacher(teacher) ;
		
		System.out.println("This is the list of teachers ");
		for (Teacher t : teacher) {
			  System.out.println("  " + t.email);
		}
		
	}
	
	/**************************************************************************************/
	
	public void Add_teacher (Teacher teacher) {
		 
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter("C:\\Users\\asus\\Documents\\project1-files\\teacherAutentification.csv",true)) ;
			Scanner scanner = new Scanner(System.in) ;
			
			System.out.println("   Enter the name of teacher");
			String name = scanner.nextLine();
			
			System.out.println("   Enter the email of teacher");
			String email = scanner.nextLine() ;
			
			System.out.println("   Enter the department of teacher");
			String dep = scanner.nextLine() ;
			
			System.out.println("   Enter the module that this teacher studied");
			String module = scanner.nextLine();
			
			System.out.println("   Enter the grade");
			String grade = scanner.nextLine();
			
			write.append(name + "," + dep + "," + email + "," + module + "," + grade) ;
			System.out.println("The registration has been successed");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	 /**************************************************************************************/
	
	public static void delete_teacher (String email) {
		
		ArrayList<Teacher> teacher = new ArrayList<Teacher>() ;
		teacher = Teacher.Read_Teacher(teacher) ;
		
		for (Teacher t:teacher) {
			 if(t.email.equals(email)) {
				  teacher.remove(t) ;
			 }
		}
		Adiminstrator.write_teacher(teacher);
	}

}
