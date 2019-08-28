
package dao;

import java.util.ArrayList;
import model.Enseignant;
import model.Enseignant;
import model.Etudiant;
import model.Etudiant;
import model.Planning;
import model.Planning;


public interface Iconnexion {

public boolean connexion( String nom, String prenom, String password );
public void ajoutAdmin ( String nom, String prenom, String password );
public void suppAdmin(String nom, String prenom); 
public void suppPlanning(String idPl );
public void ajoutPlanning(String faculte,String niveau,String semestre,String annee,String departement,String specialite );
public void ajoutEtudiant(String matricule, String nom, String prenom, String specialite, String niveau, String groupe );
public void ajoutEnseignant(String codeBarreEn, String nom, String prenom);
public void suppEnseignant(String codeBarreEn);
public ArrayList<Planning> consultePlannings(String annee, String faculte,String departement, String niveau, String semestre);
public ArrayList<Etudiant> consulteEtudiants(String idPl, String nom, String prenom, String niveau, java.sql.Date date, String module );
public ArrayList<Enseignant> consulteEnseignants(String idPl, String nom, String prenom, String lieu, String module, java.sql.Date dateExamen );
public void ajoutExamen  (String module, String lieu, java.sql.Date dateExamen , String heure,  String idPl );
public void ajoutPresence(String matricule , String module,String idPl, String codebarreEn );
    
}
