
package controle;

import dao.DAO;
import model.Presence;


public class ContrPresence{
    
      private static  DAO d ;   

    public  ContrPresence(){
   
    if(d == null ){
    d = new DAO();
    }
    }
    
    /**
     * pour l'état et l'heure du pointage c'est au moment de la récupération de la presence
     * que c'est information seront fournies 
     * @param presence 
     */
    public void ajoutPresence(Presence presence){
        d.ajoutPresence(presence.getMatricule(),
                presence.getModule(),
                presence.getIdPl(),
                presence.getCodeBarreEn());
    }
    
}
