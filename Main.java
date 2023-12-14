package student_managment;

import java.io.IOException;
import java.util.*;


public class Main {

	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {


		
	  Person p ;	

      
         
    ArrayList<Root> root2 = null;
    root2 = Root.deserializble() ;
    for (Root r : root2) {
       System.out.println(r.email);
      
    }
    
           p = VerificationIdentite.MarkIdentite() ;
 
	  
      while((p.department_type.equals("None"))) {  
    	  System.out.println("\n" + "Try again.... ");
    	  p = VerificationIdentite.MarkIdentite() ;  
      }  

         InputOutputManipulation.choice_operation(p.name, p.email);
//   	  while (true) {
//		   InputOutputManipulation.display_choice(p.department_type);
//			key = scanner.nextInt() ;
//			scanner.nextLine();
//
//		  switch (key) {
//		     case 1: { 
//		 		 System.out.print("Enter the number of student : ");
//				 number_student = scanner.nextInt();
//		    	 InputOutputManipulation.scanner(number_student, allstudent);
//		    	 FileManipulation.write(allstudent);
//		    	 Thread.sleep(5000);
//		    	 break ;
//		   }
//		     case 2 :{ // We must read from file to display the student list .
//		    	 InputOutputManipulation.display_student(allstudent);
//		    	     break ;
//		     } 
//		     case 3 : {
//		    	 g.calcfinalgrade(allstudent,p.email);
//		    	 g.displayfinalgrade(allstudent,p.email);
//		    	 Thread.sleep(5000);
//		    	   break; 
//		     }
//		     case 4 :{
//		    	 a.displayattendance(allstudent,p.email);
//		    	 Thread.sleep(5000);
//		    	 break ;
//		     }
//		     case 5 :{
//		    	 a.attendencepercentage(allstudent);
//		    	 Thread.sleep(5000);
//		    	 break ;
//		     }
//		     case 6 :{
//		    	  String receiver ;
//		    	  System.out.print("Enter the email for receiver : ");
//		    	  receiver = scanner.nextLine();
//				  NotificationService.SendEmail(receiver,allstudent);
//				  Thread.sleep(5000);
//				   break ;
//    
//		     }
//		     case 7 : {
//		    	 NotificationService.SendMessage(allstudent);
//		    	 Thread.sleep(5000);
//		    	 break ;
//		     }
//		     case 8 : {
//		    	 System.exit(0);
//		    	 break ;
//	     }
//		    default://	    	  break ;
//		 }
//		  System.out.println("\n");
//   	  }
	}
}