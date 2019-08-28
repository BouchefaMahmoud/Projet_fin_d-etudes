
package model;

import java.io.Serializable;

public class Enseignant implements Serializable{

    private String codeBarre ;
    private String nom ;
    private String prenom ;

    public Enseignant(String codeBarre, String nom, String prenom) {
        super();
        this.codeBarre = codeBarre;
        this.nom = nom;
        this.prenom = prenom;
    }

 
    
    public Enseignant(){
        super();
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
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

    @Override
    public String toString() {
        return "Enseignant{" + "codeBarre=" + codeBarre + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
    
    
}
