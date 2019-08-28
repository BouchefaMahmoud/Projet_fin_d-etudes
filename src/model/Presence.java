
package model;

import java.io.Serializable;


public class Presence implements Serializable{
  
  private String idPl ;
  private String matricule ; 
  private String module ; 
  private String codeBarreEn ; 
  private String etat ; 
  private String heurePointage ;

    public Presence(String matricule, String module, String idPl, String codeBarreEn, String heurePointage, String etat) {
      
        this.matricule = matricule;
        this.module = module;
        this.idPl = idPl;
        this.codeBarreEn = codeBarreEn;
        this.heurePointage =heurePointage;
        this.etat = etat;
    }

    
   

    public Presence() {
    super();
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String idExamen) {
        this.module = idExamen;
    }

    public String getCodeBarreEn() {
        return codeBarreEn;
    }

    public void setCodeBarreEn(String codeBarreEn) {
        this.codeBarreEn = codeBarreEn;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getIdPl() {
        return idPl;
    }

    public void setIdPl(String idPl) {
        this.idPl = idPl;
    }

    @Override
    public String toString() {
        return "Presence{" + "idPl=" + idPl + ", matricule=" + matricule + ", module=" + module + ", codeBarreEn=" + codeBarreEn + ", etat=" + etat + ", heurePointage=" + heurePointage + '}';
    }
  
    
    
  
}
