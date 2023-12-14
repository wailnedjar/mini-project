package student_managment;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NotificationService {
	
	 static Properties setup () {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true") ;
			properties.put("mail.smtp.starttls.enable","true") ;
			properties.put("mail.smtp.host", "localhost") ;
			properties.put("mail.smtp.port","587") ;
			
			return properties;

	 }
	 static void SendEmail (String receiver , AllStudent all_student ) {
		
	    Properties properties = setup();	 
		 
		String email = "zaterahmed62@gmail.com" ;
		String password = "dwez lvox eypb rdss";
		Session session = Session.getInstance(properties, null) ;
			
		Message message = prepareMessage(session,email,receiver,all_student) ;
		try {
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", email, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
			System.out.println("The email was sending ");
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
	}

			
      private static Message prepareMessage	(Session session , String sender , String receiver,AllStudent all_student) {
    	  
    	  try {
        	Message message = new MimeMessage(session) ;
			message.setFrom(new InternetAddress(sender));
	    	message.setSubject("Notification about student managment system");
            message.setRecipients(Message.RecipientType.TO,  InternetAddress.parse(receiver));
            
            String [] list_name = Attendence.studentexclue(all_student) ;
            int i = 0 ;
            String mess= "This is the list of student exceluding\n";
            while (list_name[i] != null) {
            	mess +=  "  " + list_name[i] + "\n"  ;
    	    	i++ ;

            }
	    	message.setText(mess);

	    	
	    	return message ;

		} catch (Exception e) {
			
			e.printStackTrace();
		} 
    	  
    	 return null ;
    }
      
    static void SendMessage(AllStudent all_student) {
    	
        String [] list_name = Attendence.studentexclue(all_student) ;
        int i = 0 ;
        String mess= "This is the list of student exceluding send them message to come \n";
        while (list_name[i] != null) {
        	mess +=  "  " + list_name[i] + "\n"  ;
	    	i++ ;
	    	
        }
        System.err.println(mess);
    	
    }    
}

