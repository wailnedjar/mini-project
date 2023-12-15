package Prancipal_Package;

import java.io.Serializable;

public class Cycle_Ingenieur implements Cycle_Etudes, Serializable{
	

    public Cycle_Ingenieur()
    {
    
    }

    public String getNomCycle() {
        return "Cycle Ingénieur";
    }

    public int getDureeCycle() {
        return 5; 
    }
  
}
