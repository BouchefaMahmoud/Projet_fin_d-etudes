
package controle;
import dao.DAO;
import java.util.ArrayList;
import model.Planning;

public class ControlePlanning {
    
private static  DAO d ;   

    public  ControlePlanning(){
    super();
    if(d == null ){
    d = new DAO();
    }
    }


    public void ajoutPlanning(Planning planning){
        d.ajoutPlanning(
                planning.getFaculte(),
                planning.getNiveau(),
                planning.getSemestre(), 
                planning.getAnnee(),
                planning.getDepartement(),
                planning.getSpecialite()); 
            }


    public ArrayList<Planning> consultePlannings(String annee, String faculte,String departement, String niveau, String semestre){
        ArrayList<Planning> plannings = new ArrayList<Planning>();
        plannings = d.consultePlannings(annee, faculte, departement, niveau, semestre);
        return plannings;
    }

    
}
