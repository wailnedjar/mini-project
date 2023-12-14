package student_managment;

import java.util.*;

public class InputOutputManipulation {

	final static int MAX_MODULES = 3;


	static void display_choice(String type) {
		System.out.print("\n\n");
        System.out.flush();

        // Message to display
        String welcomeMessage = "Welcome to the Student Management System";

        // Calculate the padding on the left and right
        int padding = (100 - welcomeMessage.length()) / 2;
        
        // Display the welcome message surrounded by '|' characters
        System.out.println(" ".repeat(10)  + "_".repeat(80) + "_" + "\n");
        System.out.println("" + " ".repeat(padding) + welcomeMessage + " ".repeat(padding) + "\n");
        System.out.println(" ".repeat(10) + "_".repeat(80) + "_" );
        
        System.out.println("\n\n");
        
        if (type.equalsIgnoreCase("student")) {
        	System.out.println("1:Calculating the final grade");
        	System.out.println("2:Dispaly the attendence list");
        	System.out.println("3:Exit from the program");
        } 
        if(type.equalsIgnoreCase("teacher")) {
        	System.out.println("1:Display all student");
        	System.out.println("2:Display admitted student");
        	System.out.println("3:Add student");
        }
        if (type.equalsIgnoreCase("admin")) {
        	System.out.println("1:Display all teachers email");
        	System.out.println("2:Add teacher");
        	System.out.println("3:Remove teacher");
        }
	}
	
	static void choice_operation (String type , String email) throws InterruptedException {
		
		AllStudent all_student = new AllStudent() ;
		FileManipulation.read(all_student);
		int choice ; 
		Scanner scanner = new Scanner(System.in) ;
		
		Grade g = new Grade() ;
		Attendence a = new Attendence() ;
		
		if (type.equalsIgnoreCase("student")) {
		while (true) {
	          InputOutputManipulation.display_choice(type);
	         System.out.println("Enter your choice");
	          choice = scanner.nextInt() ;

			switch (choice) {
			  case 1 :{
					
					  g.calcfinalgrade(all_student); 
					  g.displayfinalgrade(all_student,email); 
					  Thread.sleep(5000); 
					  break;
			          }
			  case 2 :{
			    	 a.displayattendance(all_student,email);
			    	 Thread.sleep(5000);
			    	 break ;
			         }
			  case 3 : {
				  System.exit(0);
				  break ;
			          }
			}          
		  }
	  }
		
       
	   if (type.equalsIgnoreCase("teacher")) {
		   
		   while (true) {
		          InputOutputManipulation.display_choice(type);
		          
			      System.out.println("Enter your choice");
			      choice = scanner.nextInt() ;
			      scanner.nextLine() ;
			   switch(choice) { 
			     case 1 : {
			    	 Teacher.display_student(all_student);
			    	 Thread.sleep(5000);
			    	 break ;
			     }
			     case 2 : {
			    	 Teacher.display_admitted(all_student);
			    	 Thread.sleep(5000);
			    	 break; 
			     }
			     case 3 : {
			 		 int number_student = scanner.nextInt();
			    	 Teacher.add_Student(number_student, all_student);
			    	 Teacher.display_student(all_student);
			    	 Thread.sleep(5000) ;
			    	 break ;
			       }
			     case 4 :{
			    	 System.exit(0);
			    	 break ;
			     }
			       
			   }
		   }
		   
	   }
		
		
		
	}
	
}
