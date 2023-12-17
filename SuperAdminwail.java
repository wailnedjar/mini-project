package studentmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SuperAdmin extends Person {
    final Map<Integer, List<String>> PermitionList = InitialisePermition();
	public static Map<Integer, List<String>> InitialisePermition() {
	    	    Map<Integer, List<String>> PermitionList = new HashMap<>();
	    	    PermitionList.put(1, new ArrayList<>(List.of("AddStudent","RemoveStudent,ReamoveTeacher")));
	    	    PermitionList.put(2, new ArrayList<>(List.of("AddTeacher","RemoveTeacher")));
	    	    PermitionList.put(3, new ArrayList<>(List.of("AddStudent","RemoveTeacher","AddTeacher","RemoveTeacher")));
	    	    return PermitionList;
	      }
    
	    public SuperAdmin(String name, String gender, String phone, String birth, int ID, Adresse adresse, String email) {
	        super(name, gender, phone, birth, ID, adresse, email);
	    }

        // Display permissions
        	    public void addAdministrator() {
	    	Scanner scanner = new Scanner(System.in);
	        // Get administrator information from user input
	        System.out.println("Enter Administrator name:");
	        String name = scanner.nextLine();
	        System.out.println("Enter administrator gender:");
	        String gender = scanner.nextLine();
	        System.out.println("Enter administrator phone:");
	        String phone = scanner.nextLine();
	        System.out.println("Enter administrator birth:");
	        String birth = scanner.nextLine();
	        System.out.println("Enter administrator Email:");
	        String Email = scanner.nextLine();
	        System.out.println("Enter administrator Adress:");
	        Adresse Adress = new Adresse();
	        Adress.setAdresse();
	        System.out.println("Enter administrator level:");
	        int level = scanner.nextInt();
	      //ArrayList<String> Permition =;   
	        scanner.nextLine();
	      //  if (permissions != null) {        	  
            List<String> permissions = this.getPermissions(level);
    	    System.out.println("Permissions for Level " + level + ":");
            if (permissions != null) {
                for (String permission : permissions) {
                    System.out.println(permission);
                    Admin admin = new Admin(name, gender, phone,birth,00,Adress,Email, permission, level, null);            
                }
            } else {
                System.out.println("Invalid Level");
            }
        }

        public List<String> getPermissions(int key) {
            return PermitionList.get(key);
        }



}
