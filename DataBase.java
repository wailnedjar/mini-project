package student_managment;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class DataBase {

	 StudentInfo Download_Student_Database (String name , ArrayList <ModuleInfo> grades , Map <LocalDate,Integer>attendence,String email ) {	
		String url = "jdbc:mysql://localhost:3306/student" ;
		String username = "root" ;
		String password = "21072004";
		String dep = "" ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			Connection connection = DriverManager.getConnection(url,username,password) ;
			Statement stmt = connection.createStatement() ;
			String query = "SELECT grades.poo_mark ,grades.alco_mark , grades.sfsd_mark ,"
					      + "grades.ana_mark , grades.alg_mark ,grades.stat_mark ,student.name ,"
					      + " student.id  FROM student "
					      + "INNER JOIN grades "
					      + "ON grades.id = student.id" ;
			ResultSet res =   stmt.executeQuery(query) ;
			
			while (res.next()) {
				name = res.getString("name");
				
				
			}
			connection.close();
		}
		catch(Exception e ) { // exit with error and left the program .
			System.out.println("cannot read from database \n");
			System.exit(1);
		}
		StudentInfo infostudent = new StudentInfo(name,email,dep,grades,attendence) ;	
	    return infostudent ; 

	}
}
