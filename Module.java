public class Module{

    String moduleName;
    String Niveau;
    Cycle Formation;
    String Prof;
    int Hours;
    int Coef;
    int Credits;
    T Td;
    T Tp;
    public Module(String moduleName, String niveau, Cycle formation, String prof, int hours, int coef, int credits) {
        this.moduleName = moduleName;
        Niveau = niveau;
        this.Formation = formation;
        Prof = prof;
        Hours = hours;
        Coef = coef;
        Credits = credits;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
    }

    public String getFormation() {
        return Formation;
    }

    public void setFormation(String formation) {
        Formation = formation;
    }

    public String getProf() {
        return Prof;
    }

    public void setProf(String prof) {
        Prof = prof;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int hours) {
        Hours = hours;
    }

    public int getCoef() {
        return Coef;
    }

    public void setCoef(int coef) {
        Coef = coef;
    }

    public int getCredits() {
        return Credits;
    }
    
    public void setCredits(int credits) {
        Credits = credits;
    }

    

}
