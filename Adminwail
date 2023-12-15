package Student_Managment_System;

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
    public Admin(String name, String gender, String phone, Date birth,int ID, Adresse adresse, String dress,String AdminID,int L,ArrayList<Integer> Per) {
		super(name, gender, phone, birth, ID, adresse, dress);
		this.Level=L;
//		this.Permition=Per;
		 Modules=new ArrayList();
		
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

