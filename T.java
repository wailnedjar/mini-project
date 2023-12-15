package mini;
import java.util.ArrayList;
public class T {
	private int NumbreOfWeeks;
	private int NumbreOfScience;
	private String TeacherResponsable;
	private int numberScienceparsemain;
    private ArrayList<String> Audiences;
    private ArrayList<Integer> Participation;
    private ArrayList<String> Certificat;
    private float TPAverrage;
    private float ParticipationNote;
    private float AudienceNote;
    public TP(int numberScienceparsemain,String TeacherResponsable) {
        this.numberScienceparsemain = numberScienceparsemain;
        this.Audiences = new ArrayList<String>();
        this.Participation= new ArrayList<Integer>();
        this.Certificat = new ArrayList<String>();
        this.TeacherResponsable=TeacherResponsable;
        this.TPAverrage=0.0f;
        this.NumbreOfWeeks=0;
        this.AudienceNote=0.0f;
        this.ParticipationNote=0.0f;
    }
    // Getters
    public String getTeacherResponsable() {
        return TeacherResponsable;
    }
    public int getNumberScienceparsemain() {
        return numberScienceparsemain;
    }
    public int getNumbreOfScience() {
        return NumbreOfScience;
    }
    public int getNumbreOfWeeks() {
        return NumbreOfWeeks;
    }
    public float getAudienceNote() {
        return AudienceNote;
    }
    public float getParticipationNote() {
        return ParticipationNote;
    }
    public float getTPAverrage() {
        return TPAverrage;
    }
    public ArrayList<String> getAudiences() {
        return Audiences;
        
    }
    public ArrayList<String> getAudiencesweek(int week) {
    	ArrayList<String>	Audiencesweek = new ArrayList<String>();    
    	for(int i=this.numberScienceparsemain;i>0;i--) {
       Audiencesweek.add(Audiences.get(week*this.numberScienceparsemain-i));
    	}
    	return Audiencesweek;  
    }
    
    public ArrayList<Integer> getParticipationweek(int week) {
    	ArrayList<Integer>	Participationsweek = new ArrayList<Integer>();    
    	for(int i=this.numberScienceparsemain;i>0;i--) {
       Participationsweek.add(Participation.get(week*this.numberScienceparsemain-i));
    	}
    	return Participationsweek;  
    }
    public ArrayList<Integer> getParticipation(){
    	return Participation;
    }
    public  ArrayList<String> getCertificat() {
        return Certificat;
    }
    // Setters
    public void SetParticipationNote(float ParticipationNote) {
        this.ParticipationNote= ParticipationNote;
    }
    public void SetAudienceNote(float AudienceNote) {
        this.AudienceNote=AudienceNote;
    }
    
    public void setTeacherResponsable(String TeacherResponsable) {
        this.TeacherResponsable = TeacherResponsable;
    }
    public void setTPAverrage(float TPAverrage) {
        this.TPAverrage = TPAverrage;
    }
    
    public void setNumberScienceparsemain(int numberScienceparsemain) {
        this.numberScienceparsemain = numberScienceparsemain;
    }
    public void setNumbreOfScience(int NumbreOfScience) {
        this.NumbreOfScience= NumbreOfScience;
    } 
    public void AddAudiences(String Audiences) {
        this.Audiences.add(Audiences);
    }
    public void AddParticipation(int Participation) {
        this.Participation.add(Participation);
    }
    public void setCertificat(String Certificat) {
    this.Certificat.add(Certificat);
    }
    public void RemoveCertificat(int NumbreOfCertificat) {
    	this.Certificat.remove(NumbreOfCertificat);
    }
    public void SetTPAverrage(float TPAverrage) {
    this.TPAverrage=TPAverrage;	
    }
    // Method to replace an element in Audiences
    public void replaceAudience(int week,int science, String newAudience) {
        if (week >0) {
        	int j=week*this.getNumberScienceparsemain();
           if(Audiences.get(j-science)!=newAudience) {
        	Audiences.set(j-science, newAudience);
            System.out.println("Audience replaced successfully.");
        }
           else {
               System.out.println("Audience is Alredy "+newAudience);        	   
           }
        }else {
            System.out.println("Audience not found.");
        }
    }
    public void replaceParticipationscience(int week,int science, int newParticipation) {
        if (week >0&&science<=this.getNumberScienceparsemain()) {
        	int j=week*this.getNumberScienceparsemain();
           if(Participation.get(j-science)!=newParticipation) {
        	Participation.set(j-science, newParticipation);
            System.out.println("Audience replaced successfully.");
        }
           else {
               System.out.println("Audience is Alredy "+newParticipation);        	   
           }
        }else {
            System.out.println("Audience not found.");
        }
    }
    void CalculateAudienceNote() {
    String j=null;
   float k=0;
    	for(int i=0;i<this.NumbreOfWeeks*this.numberScienceparsemain;i++) {
    	j=this.Audiences.get(i);
    	switch(j) {
    	case "Audience":{
    		k=k+1;
    		break;
    	}
    	case "Absence":{
    		break;
    	}
    	case "Justification":{
    		k=k+(0.5f);
    		break;
    	}
    	}
     }
    k=(k*10)/this.numberScienceparsemain*this.NumbreOfWeeks;
    this.SetAudienceNote(k);
    }
    void CalculateParticipationNote() {
    	int j=0;
    	 int  k=0;
    	    	for(int i=0;i<this.numberScienceparsemain*this.NumbreOfWeeks;i++) {
    	    	j=this.Participation.get(i);
    	    	switch(j) {
    	    	case 1 :{
    	    		k=k++;
    	    		break;
    	    	}
    	    	case 0:{
    	    		break;
    	    	}
    	    	case -1:{
    	    		k=k--;
    	    		break;
    	    	}
    	    	}
    	     }	
    	    float p=(k*10)/this.numberScienceparsemain*this.NumbreOfWeeks;
    	    this.SetParticipationNote(p);	
    }
    void CalculateTPAverrage() {
    this.CalculateAudienceNote();
    this.CalculateParticipationNote();
    this.setTPAverrage(this.getAudienceNote()+this.getParticipationNote());
    }
    public void DisplayAudiences() {
    	
    	System.out.println("Audiences : ");
        int k=this.Audiences.size();
        int l=1;
        for( int i=0;i<k;i++) {
        if(i%this.numberScienceparsemain==0) {
        System.out.println("Week "+l+" : ");
        l++; 	
        }	
        System.out.println(this.Audiences.get(i));
        }
        
    }
    public void DisplayParticipation() {
    	System.out.println("Participation :");
        int k=this.Participation.size();
       int l=1;
        for ( int i=0 ;i< k;i++) {
            if(i%this.numberScienceparsemain==0) {
                System.out.println("Week "+l+" : ");
                l++; 	
                }	
        	System.out.println(this.Participation.get(i));
            }

    }
    public void  DisplayCertifcat() {
    	
    	System.out.println("Certificat:");
        for (int i=0;i< Certificat.size();i++) {
            System.out.println("Certificat 1 ");
            System.out.println(Certificat.get(i));    
        }       
    	
    }
    public void displayAllInfo() {
        System.out.println("TP Module Information:");
        System.out.println("Teacher Responsable: " + TeacherResponsable);
        System.out.println("Number of Sciences per Semain: " + numberScienceparsemain);
        System.out.println("Number of Weeks: " + NumbreOfWeeks);

        // Displaying Audiences
        this.DisplayAudiences();
        // Displaying Participation
        this.DisplayParticipation();
        // Displaying Certificat
        this.DisplayCertifcat();
        
        if(Audiences.size()==this.NumbreOfScience&&Participation.size()==this.NumbreOfScience) {
        this.CalculateAudienceNote();
        this.CalculateParticipationNote();
        this.CalculateTPAverrage();
        System.out.println("TP Average: " + TPAverrage);
        System.out.println("Participation Note: " + ParticipationNote);
        System.out.println("Audience Note: " + AudienceNote);
        }
        }
}
