
package model;

import java.io.Serializable;


public class Administration implements Serializable {
   
    
    private String nom ; 
    private String prenom ; 
    private String password ;

    public Administration(String nom, String prenom, String password) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
    }

    public Administration() {
        super();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
