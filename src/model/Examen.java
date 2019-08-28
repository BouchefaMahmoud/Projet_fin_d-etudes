
package model;

import java.io.Serializable;
import java.util.Date;

public class Examen implements Serializable{
    
    private String lieu ;
    private String heure ;
    private Date dateExam ;
    private String module ;
    private String idPl ; 

    public Examen() {
        super();
    }

    public Examen(String module, String lieu, String heure, Date dateExam, String idPl){
        super();
      
        this.lieu = lieu;
        this.heure = heure;
        this.dateExam = dateExam;
        this.module = module;
        this.idPl = idPl ;
    }

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }

    
    

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getIdPl() {
        return idPl;
    }

    public void setIdPl(String idPl) {
        this.idPl = idPl;
    }

    @Override
    public String toString() {
        return "Examen{" + "lieu=" + lieu + ", heure=" + heure + ", dateExam=" + dateExam + ", module=" + module + ", idPl=" + idPl + '}';
    }
    
    
    
}
