
package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Planning  implements Serializable{

    private String faculte ;
    private String niveau ;
    private String semestre;
    private String annee ;
    private String departement ; 
    private String specialite ;
    private String idPl ;
   
    
    public Planning(String faculte, String departement, String niveau, String semestre, String annee, String specialite ){
    
        this.faculte = faculte;
        this.departement=departement;
        this.niveau = niveau;
        this.semestre = semestre;
        this.annee = annee; 
        this.specialite = specialite ;
    }

    /**
     * constructeur sans idPl
     */
    
    public Planning(String idPl,String faculte, String niveau, String semestre, String annee, String departement, String specialite) {
        this.faculte = faculte;
        this.niveau = niveau;
        this.semestre = semestre;
        this.annee = annee;
        this.departement = departement;
        this.specialite = specialite;
        this.idPl = idPl;
    }

    
    
    
    
    public Planning() {
        super();
    }

  
    public String getFaculte() {
        return faculte;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    
    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return "Planning{" + "faculte=" + faculte + ", niveau=" + niveau + ", semestre=" + semestre + ", annee=" + annee + ", departement=" + departement + ", specialite=" + specialite + ", idPl=" + idPl + '}';
    }

   
    
    
}
