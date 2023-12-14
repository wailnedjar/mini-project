package student_managment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Teacher extends Person {
     
	 String module ;
	 String grade;
	 ArrayList <Teacher> teachers = new ArrayList<Teacher>() ;
	 
	 Teacher (String name ,String email , String department_type ,String module ,String grade){
	     super(name, email, department_type);
	     
		 this.module = module ;
		 this.grade = grade ;
		 this.teachers.add(this) ;
	 }
	 
	public static ArrayList<Teacher> Read_Teacher (ArrayList<Teacher> teachers) {
		String name ,dep , module , email, grade;
		try {
			
			BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\asus\\Documents\\project1-files\\teacherAutentification.csv")) ;
			
			String line = read.readLine() ;
			
			  while ((line = read.readLine() ) != null  ) {	
					String [] arr = new String [5] ;
					arr = line.split(",") ;
					name = arr[0] ;
					dep = arr[1] ;
					email = arr[2] ;
					grade = arr[3] ;
					module = arr[4] ;
					teachers.add(new Teacher(name,email,dep,module,grade)) ;			
			}
		} catch (Exception e) {
			System.out.println("No file");
		}
		return teachers;
	}
	
	/***********************************************************************/
	
	// The teacher can view his module only .
	static void display_admitted (AllStudent all_student) {
		System.out.println("Miss / Sir "  + " this is your list of student who are admitted ");
		Grade g = new Grade () ;
		g.calcfinalgrade(all_student) ;
		for (StudentInfo student : all_student.list_student.values()) {
	
				if( student.getfinalgrade() >= 10) {
					System.out.println(student.name + " is admitted ");
				}
				
		}
	}	
	
	/***********************************************************************/
	
		static void display_student(AllStudent all_student) {

			System.out.println("This is the list of student ");
			System.err.println("id\tname");

			
			  Set<String> id = all_student.list_student.keySet() ; Iterator<String>
			  iterator = id.iterator();
			  
			  for (StudentInfo st : all_student.list_student.values()) {
			        System.err.println(iterator.next() +"\t" + st.name); 
			  }
          }
		/***********************************************************************/
		
		public static void add_Student(int number_student, AllStudent all_student) {

			String id, name, module_name, quit , departemnt_type;
			LocalDate date;
			float mark; 
			int attend , coefficion; 
			ArrayList<ModuleInfo> grades = new ArrayList<>();
			HashMap<LocalDate, Integer> attendance = new HashMap<>();
			
			int MAX_MODULES = 3 ;

			Scanner scanner = new Scanner(System.in);

			for (int i = 1; i <= number_student; i++) {

				System.out.print("Enter the name of student " + i + " ");
				name = scanner.nextLine();

				System.out.print("Enter the id of student " + i + " ");
				id = scanner.nextLine();
				
				System.out.println("Enter the department of student " + i + " ");
				departemnt_type = scanner.nextLine() ;

				System.out.println("Enter the mark for each module ");

				// For reading grades for each module . ( we have 3 modules by default ;
				for (int j = 0; j < MAX_MODULES; j++) {
					System.out.print("Enter the module name ");
					 module_name= scanner.nextLine();
					 System.out.println("Enter the mark");
					 mark = scanner.nextFloat() ;
					 scanner.nextLine() ;
					 System.out.println("Enter the coefficion");
					 coefficion = scanner.nextInt() ;
					 scanner.nextLine() ;
					 grades.add (new ModuleInfo(module_name, mark, coefficion));
				}
				// For reading dates for each student .
				System.out.println("Enter the number of date which you would register");
				int nb_date = scanner.nextInt();
				scanner.nextLine();
				int k = 0;
				System.out.println("Enter the date format like this pattern yyyy-mm-dd if he/she present" + "press 1 else 0");

				while (k < nb_date) {
					System.out.print("date : ");
					date = LocalDate.parse(scanner.next(), DateTimeFormatter.ISO_LOCAL_DATE);
					attend = scanner.nextInt();
					scanner.nextLine();
  
					k++;
					attendance.put(date, attend);
				}    
				System.out.println("Enter the email");
				String email11 = scanner.nextLine() ;
				StudentInfo s = new StudentInfo(name,email11, departemnt_type, grades, attendance);
				all_student.Add_Student(id, s);
				FileManipulation.write(all_student ) ;
			}
		}	
}
