
package controle;

import dao.DAO;
import java.util.ArrayList;
import model.Etudiant;

public class ControleEtudiant {
    
    private static DAO d ; 
    
    public ControleEtudiant(){
        super();
         if(d == null ){
          d =new DAO();
         }
    }
    
    public void ajoutEtudiant(Etudiant etudiant){
        d.ajoutEtudiant(etudiant.getMatricule(),
                etudiant.getNom(), 
                etudiant.getPrenom(), 
                etudiant.getSpecialite(), 
                etudiant.getNiveauEtude(), 
                etudiant.getGroupe());
    }
    
    public ArrayList<Etudiant> consulteEtudiants(String idPl, String nom, String prenom, String niveau, java.util.Date date, String module ){
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
       etudiants = d.consulteEtudiants(idPl, nom, prenom, niveau, sqlDate, module);
      
       return etudiants;
    }

}
