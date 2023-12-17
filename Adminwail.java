package  Student_Managment_System;

import java.util.*;

public class Admin extends Person{

     private int Level;
     final Map<Integer, List<String>> PermitionList = InitialisePermition();
     ArrayList<Module> Modules;
     ArrayList<String> Lev1=new ArrayList<String>();
     public static Map<Integer, List<String>> InitialisePermition() {
    	    final Map<Integer, List<String>> PermitionList = new HashMap<>();
    	    PermitionList.put(1, new ArrayList<>(List.of("Adds","Rmst")));
    	    PermitionList.put(2, new ArrayList<>(List.of("Addt","Rmt")));
    	    PermitionList.put(3, new ArrayList<>(List.of("Adds","Rmst","Addt","Rmt")));
    	    return PermitionList;
        
    	}

    public Admin(String name, String gender, String phone, String birth,int ID, Adresse adresse, String dress,String AdminID,int L,ArrayList<Integer> Per) {
		super(name, gender, phone, birth, ID, adresse, dress);
		this.Level=L;
//		this.Permition=Per;
		 Modules=new ArrayList();
		
	}

    
    public void addStudent() {
    	Scanner scanner=new Scanner(System.in);

    	System.out.print("ENTER NAME :");
    	String name=scanner.nextLine();
    	System.out.print("ENTER GENDER :");
    	String gender=scanner.nextLine();
    	System.out.print("ENTER PHONE :");
    	String phone=scanner.nextLine();
    	System.out.print("ENTER DATE OF BIRTH :");
    	String date_of_birth=scanner.nextLine();
    	System.out.print("ENTER ID :");
    	int ID=scanner.nextInt();
    	scanner.nextLine();
    	
    	System.out.print("ENTER COUNTRY :");
    	String country=scanner.nextLine();
    	System.out.print("ENTER CITY :");
    	String city=scanner.nextLine();
    	System.out.print("ENTER STREET :");
    	String street=scanner.nextLine();
    	System.out.print("ENTER HOUSE NUMBER :");
    	String houseNum=scanner.nextLine();
    	Adresse adresse=new Adresse(country,city,street,houseNum);
    	System.out.print("ENTER EMAIL :");
    	String Email=scanner.nextLine();
    	System.out.print("ENTER PROMOTION :");
    	String promotion=scanner.nextLine();
    	System.out.print("ENTER SECTION :");
    	int section=scanner.nextInt();
    	System.out.print("ENTER GROUPE :");
    	int groupe=scanner.nextInt();
    	Student s=new Student(name,gender,phone,date_of_birth,ID, adresse,Email,promotion,section,groupe);
        
    	AllList.students.add(s);
    	
    }
    
    public void removeStudent() {
    	Scanner scanner=new Scanner(System.in);

    	System.out.print("ENTER ID you want to delete :");
    	int ID=scanner.nextInt();
    	boolean b=false;
    	int i=0;
    	while(i<AllList.student.size()&& b==false) {
    		if(AllList.student.get(i).getID==ID) {
    			AllList.student.remove(i);
    			b=true;
    		}
    	}
    	if(b==false) {
    		System.out.println("ID DOESN'T EXIST !!!!!");
    	}
    	else {
    		System.out.println("REMOVE SUCCEFULY ");
    	}
    	
    }
    
    public void addteacher() {
    	Scanner scanner=new Scanner(System.in);

    	System.out.print("ENTER NAME :");
    	String name=scanner.nextLine();
    	System.out.print("ENTER GENDER :");
    	String gender=scanner.nextLine();
    	System.out.print("ENTER PHONE :");
    	String phone=scanner.nextLine();
    	System.out.print("ENTER DATE OF BIRTH :");
    	String date_of_birth=scanner.nextLine();
    	System.out.print("ENTER ID :");
    	int ID=scanner.nextInt();
    	scanner.nextLine();
    	
    	System.out.print("ENTER COUNTRY :");
    	String country=scanner.nextLine();
    	System.out.print("ENTER CITY :");
    	String city=scanner.nextLine();
    	System.out.print("ENTER STREET :");
    	String street=scanner.nextLine();
    	System.out.print("ENTER HOUSE NUMBER :");
    	String houseNum=scanner.nextLine();
    	Adresse adresse=new Adresse(country,city,street,houseNum);
    	System.out.print("ENTER EMAIL :");
    	String Email=scanner.nextLine();
    	
    	System.out.print("HOW MANY SECTION HAVE THIS TEACHER :");
    	int nbrsection=scanner.nextInt();
    	ArrayList<Float> Sections ;
    	for(int i=0;i<nbrsection;i++) {
        	System.out.print("ENTER SECTION N°"+(i+1));
        	float section=scanner.nextFloat();
        	Sections.add(section);
    	}
    	
    	System.out.print("HOW MANY MODULE RESPONSABLE BY THIS TEACHER :");
    	int nbrmodule=scanner.nextInt();
    	ArrayList<Float> ModulesResp ;
    	for(int i=0;i<nbrmodule;i++) {
        	System.out.print("ENTER MODULE N°"+(i+1));
        	float module=scanner.nextFloat();
        	ModulesResp.add(module);
    	}
    	
    	Teacher t=new Teacher(name,gender,phone,date_of_birth,ID, adresse,Email,Sections,ModulesResp);
    	
    	AllList.teacher.add(t);
    	
    }
    
    public void removeTeacher() {
    	Scanner scanner=new Scanner(System.in);

    	System.out.print("ENTER ID you want to delete :");
    	int ID=scanner.nextInt();
    	boolean b=false;
    	int i=0;
    	while(i<AllList.teacher.size()&& b==false) {
    		if(AllList.teacherteacher.get(i).getID==ID) {
    			AllList.teacher.remove(i);
    			b=true;
    		}
    	}
    	
    	if(b==false) {
    		System.out.println("ID DOESN'T EXIST !!!!!");
    	}
    	else {
    		System.out.println("REMOVE SUCCEFULY ");
    	}
    	
    }
    
    
    
    
    
	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}
	public Admin() {
		super();
	}
	public void DispalInfo()
	{
		super.DisplayInfo();
		///contine level
	}
	

}
