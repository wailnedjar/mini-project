package Student_Managment_System;

import java.util.Date;

public class SuperAdmin extends Person{
	
	public SuperAdmin() {
		super();
	}

	public SuperAdmin(String name, String gender, String phone, Date birth, int ID, Adresse adresse, String dress) {
		super(name, gender, phone, birth, ID, adresse, dress);
	}
	public void DisplayInfo()
	{
		super.DisplayInfo();
	}
	

}

