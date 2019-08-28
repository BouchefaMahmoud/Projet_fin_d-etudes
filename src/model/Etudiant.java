
package model;

import java.io.Serializable;


public class Etudiant implements Serializable{
    
    
    private String matricule ;
    private String nom ;
    private String prenom ;
    private String groupe ;
    private String specialite ;
    private String niveauEtude;

    public Etudiant(String matricule, String nom, String groupe, String prenom, String specialite, String niveauEtude) {
        super();
        this.matricule = matricule;
        this.nom = nom;
        this.groupe =groupe ;
        this.prenom = prenom;
        this.specialite = specialite;
        this.niveauEtude = niveauEtude;
    }

    public Etudiant(String matricule, String nom, String prenom, String groupe) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
    }

    
    
    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
    
    
    
    public Etudiant(){
     super();
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", groupe=" + groupe + '}';
    }

   
    
    
}
