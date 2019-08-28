
package controle;

import dao.DAO;
import model.Administration;

public  class ControleAdmin {

    private static DAO d;
    
    public ControleAdmin(){
        super();
        if( d==null){
        d =new DAO();
        }
    }
    
    
    public boolean connexion( Administration admin ){
       return d.connexion(admin.getNom(), admin.getPrenom(), admin.getPassword());
    }
    
    public void ajoutAdmin ( Administration admin ){
        d.ajoutAdmin(admin.getNom(), admin.getPrenom(), admin.getPassword());
    }

}
