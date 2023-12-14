package student_managment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Scanner;
public class VerificationIdentite {
       
	
	  public static Person MarkIdentite() {
		  
		    Scanner scanner = new Scanner(System.in) ;
		    String deptype  = null;
		    
		    System.out.println("     Who are you ? student/teacher/admin/root");
		    String type = scanner.nextLine() ;
		    
		    if  ((type.equalsIgnoreCase("student")) || (type.equalsIgnoreCase("teacher")) || (type.equalsIgnoreCase("admin"))) {
		    	 System.out.println("     In which department are you ? Lmd/Ingenier/Master");
		    	 deptype = scanner.nextLine()  ;
		    }else {
		    	deptype = "all" ; //this is for the root .
		    }
		    
		    
		    System.out.println("    Enter the email ");
		    String name_email = scanner.nextLine();
		    
		    System.out.println("    Enter the password ");
		    String password = scanner.nextLine() ;	
		    
		    Boolean b = VerificationIdentite.Login(name_email,password,type,deptype) ;
		    
		    if (b == true) {
			    return new Person(type,name_email,deptype) ;
		    }
		    return new Person(type,name_email,"None") ; // None is flag to mark the error .
	  }
	
	  // User login even teacher, student, admin .
	  private static Boolean Login (String name_email,String password,String type,String deptype) { 
		  
		    Scanner scanner = new Scanner(System.in) ;
    
		    Properties properties = NotificationService.setup() ;

			Session session = Session.getInstance(properties, null) ;
            try {
            	
                Transport transport = session.getTransport("smtp");
				transport.connect("smtp.gmail.com", name_email, password);
				System.out.println("\n\t  Login Success");
				
				if (!This_User_Exist(name_email, type,deptype)) { // verification permission.
					System.out.println("You don't have the permission to be here");
					return false ;
				}
			} catch (MessagingException | ClassNotFoundException | IOException e) {
				
				System.out.println("\n\nLogin Error Password Incorrect !!");
				return false ; 
			}		    
		    return true ;     
	  }
 /*---------------------------------------------*/
	  //Verfie the if the user is already exists (student/teacher/admin
	  private  static Boolean This_User_Exist (String name_email,String type,String deptype) throws ClassNotFoundException, IOException {
		  
		  if (type.equalsIgnoreCase("admin")) {
			  ArrayList<Adiminstrator> admin = new ArrayList<Adiminstrator>() ;
			  admin = Adiminstrator.Read_Administator(admin) ;
			  for(Adiminstrator a:admin) {
				  if( (a.email.equalsIgnoreCase(name_email)) && (a.department_type.equalsIgnoreCase(deptype))){
					  return true ;
				  }
			  }
			  return false ;
			  
			    
		  }
		  if (type.equalsIgnoreCase("teacher")) {
			  ArrayList<Teacher> t = new ArrayList<Teacher>() ;
			  t = Teacher.Read_Teacher(t) ;
			  for (Teacher teacher :t) {
				  if ( (teacher.email.equalsIgnoreCase(name_email)) && (teacher.department_type.equalsIgnoreCase(deptype))) {
					   
					  return true ;}
			  } 
			  return false ;
		  } 
		   
		  if (type.equalsIgnoreCase("student")) {
			  AllStudent all_student = new AllStudent() ;
			  FileManipulation.read(all_student);
			  for (StudentInfo st:all_student.list_student.values()) {
				    if((st.email.equalsIgnoreCase(name_email)) && (st.department_type.equalsIgnoreCase(deptype)) ) {
				    	return true ;
		  		    }
				   
			  }
			return false ;  
		  }
		  
		 if (type.equalsIgnoreCase("root")) {
			  ArrayList <Root> r = Root.deserializble() ;
			  if (r.get(0).email.equalsIgnoreCase(name_email)) { // because there is one root .
				  
				  return true ;
			  }
			  return false ;
		 }
		return null;
		  
	  }
	  
	  
	  
}
