import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Student extends Person{
	
	String TronComm;

	Student(String a , String b , int c , String d, String e){
		super(a,b,c,d);
		this.TronComm = e;
	}

	Student(String a , String b){
		super(a,b);
	}

	Student(){

	}
	
	ArrayList<INGstd> S1 = new ArrayList<>();
	ArrayList<LMDstd> S2 = new ArrayList<>();

	ArrayList<Student> INFOS = new ArrayList<>();

	public void addStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the first name of student: ");
		String firstname = scan.nextLine();
		System.out.print("Enter the last name of student: ");
		String lastname = scan.nextLine();
		boolean bo = true;
		
		while(bo) {
		System.out.println("Enter the gender of student: ");
		System.out.println("1__Male");
		System.out.println("2__Female");
		int gd = scan.nextInt();
		if(gd==1) {
			gndr="Male";
			bo=false;
		}else if(gd==2) {
			gndr = "Female";
			bo=false;
		}
		}
		System.out.print("Enter the age: ");
		int age = scan.nextInt();
		boolean bool = true;
		while(bool) {
		System.out.println("Enter the TC");
		System.out.println("1__LMD");
		System.out.println("2__ING");
		int tc = scan.nextInt();
		if(tc==2) {
			INGstd student = new INGstd(firstname , lastname , gndr  , age , "LMD");
			student = new INGstd(firstname , "aaa");
			S1.add(student);
			INFOS.add(student);
			bool=false;
		 }else if(tc==1){
		 LMDstd student = new LMDstd(firstname , lastname , gndr , age , "Ingineer");
		 student = new LMDstd(firstname , "aaa");
		S2.add(student);
		INFOS.add(student);
		bool=false;
		 }
		}	
	}




	public void displayStd() {
		 
		if(!S1.isEmpty()) {
		System.out.println("Ingineer students: ");
		   for(INGstd i : S1) {
			   System.out.println(i.firstName);
		   }
		}
		
			if(!S2.isEmpty()) {
		   System.out.println("LMD students: ");
		   for(LMDstd i : S2) {
			   System.out.println(i.firstName);
		   }
		}
		
	}



	public void viewStudentsInfos(){
		
		for(Student i : INFOS){
			System.out.println(i.firstName+","+i.lastName+": "+"username: "+i.username+"  key: "+i.Key);
		}

	}


	public boolean realStudent(String name , String key){
			boolean bool = false;
		for(Student s : INFOS){
			if(name.equals(s.username) && key.equals(s.Key)){
				bool = true;
			}
		}
	return bool;

	}


}
