package mini;

import java.util.ArrayList;

public class Teacher extends Person{
	ArrayList<Float> ModulesResp =new ArrayList<Float>();
	ArrayList<Float> Sections =new ArrayList<Float>();
	public Teacher(ArrayList<Float> Sections ,ArrayList<Float> ModulesResp ,int password, String name, String fullname, int id) {
		super(password, name, fullname, id);
		this.ModulesResp=ModulesResp;
	}
	public void DisplayInfo() {
		super.DisplayInfo();
		System.out.println("Programs responsible for it : ");
		for(int i=0;i<ModulesResp.size();i++) {
			System.out.println("Programe : "+ModulesResp.get(i));
			System.out.println("The Section is : "+Sections.get(i));	
			System.out.println();
			}		
		}

}
