
package controle;

import dao.DAO;
import model.Examen;

public class ContrExamen {
    
    private static  DAO d ;   

    public  ContrExamen(){
   
    if(d == null ){
    d = new DAO();
    }
    }
    
    
   /**
    * La date passée en paramettre doit etre du type java.util.Date
    * @param examen 
    */
    public void ajoutExamen(Examen examen ){
      
        java.sql.Date date = new java.sql.Date(examen.getDateExam().getTime());
        
        d.ajoutExamen(
                examen.getModule(), 
                examen.getLieu(), 
                date ,
                examen.getLieu(), 
                examen.getIdPl());
    }
    
}
