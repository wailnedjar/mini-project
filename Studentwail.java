package Student_Managment_System;
import java.util.*;


	public class Student extends Person{
		
		private String promotion;
		private int section,groupe;
		private ArrayList<Module> ModuleStudy;
		private  float GradeFinal;
		private Cycle Cylce_Etud;
		public Cycle getCyle() {
		return Cycle_Etudes;
	}
	public void setCyle(Cycle_Etudes cyle) {
		Cycle_Etudes = cyle;
	}
		public float getGradeFinal()
			
{
return this.GradeFinal;
}
public void SetGradeFinal(float X)
{
this.GradeFinal=X;
}
		
		public void AffecterModule()
		{
			ArrayList<modules> AllModules=AllList.Modules;
			for(Module M:AllModules )
				{
					if(M.Cycle.getNomCycle().equals(this.Cycle_Etud.getNomCycle()))
					{
						this.ModuleStudy.add(M);
					}
				}
		}
		public Student (String name,String gender,String phone,Date birth,int ID,Adresse adresse,String dress) {
			super(name,gender,phone,birth,ID,adresse,dress
			this.ModuleStudy=new ArrayList();
		}
		public String getPromotion() {
			return promotion;
		}
		public void setPromotion(String promoton) {
			this.promotion = promoton;
		}
		public int getSection() {
			return section;
		}

		public void setSection(int section) {
			this.section = section;
		}

		public int getGroupe() {
			return groupe;
		}

		public void setGroupe(int groupe) {
			this.groupe = groupe;
		}
		
		public void Displayinfo() {
			this.DisplayInfo();
			System.out.println("The Groupe :"+this.getGroupe());
			System.out.println("The Section :"+this.getSection());
			System.out.println("The Promotion :"+this.getPromotion());
		}
		
		
		

	}
