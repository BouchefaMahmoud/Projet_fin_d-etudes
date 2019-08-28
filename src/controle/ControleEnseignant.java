
package controle;

import dao.DAO;
import java.util.ArrayList;
import model.Enseignant;
public class ControleEnseignant {
        
    private static DAO d ;
        public ControleEnseignant(){
            super();
            if(d == null ){
            d=new DAO();   
            }
        }


        public void ajoutEnseignant(Enseignant enseignant ){
           d.ajoutEnseignant(enseignant.getCodeBarre(), enseignant.getNom(), enseignant.getPrenom());
        }

        public ArrayList<Enseignant> consulteEnseignants(String idPl, String nom, String prenom, String lieu, String module, java.util.Date dateExamen ){
            ArrayList<Enseignant> enseignats = new ArrayList<Enseignant>();
            java.sql.Date date = new java.sql.Date(dateExamen.getTime());
            enseignats= d.consulteEnseignants(idPl, nom, prenom, lieu, module, date);
            //controle
            return enseignats;
        }


}
