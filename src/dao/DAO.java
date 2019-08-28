package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Enseignant;
import model.Etudiant;
import model.Planning;

public class DAO implements Iconnexion {

    private Connection con;

    /**
     * Vérifie l'existence d'un adminstrateur
     * @param nom
     * @param prenom
     * @param password
     * @return true s'il existe, false sinon
     */
    @Override
    public boolean connexion(String nom, String prenom, String password) {
        con = Connexion.getConnection();
        try {
            PreparedStatement req =
                    con.prepareStatement("select password from administration where nom= ? and prenom=? ;");
            req.setString(1, nom);
            req.setString(2, prenom);
            
            ResultSet rs = req.executeQuery();
            while(rs.next()){
                if(rs.getString("password").equals(password))return true ;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return false;
    }
    /**
     * Ajout d'un nouvel adminisrateur, les champs nom et prenom sont obligatoires
     * @param nom
     * @param prenom
     * @param password  depassant pas les 30 caractères
     */
    @Override
    public void ajoutAdmin(String nom, String prenom, String password) {
        con = Connexion.getConnection();
        try {
            PreparedStatement req = con.prepareStatement("insert into administration values(?,?,?);");
            req.setString(1, password);
            req.setString(2, nom);
            req.setString(3,prenom);
            req.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
 /**
 * Ajout d'un planning
 * @param idPl
 * @param faculte
 * @param niveau { L1,L2,L3,M1,M2}
 * @param semestre {S1,S2}
 * @param annee format : annee/annee
 * @param departement
 * @param specialite valeur par defaut "aucune"
 */
    @Override
    public void ajoutPlanning(String faculte,String niveau,String semestre,String annee,String departement,String specialite ){

          con = Connexion.getConnection();
        try {
            PreparedStatement req = con.prepareStatement("insert into presence values(?,?,?,?,?);");
           
            req.setString(1, faculte);
            req.setString(2, niveau);
            req.setString(3,semestre);
            req.setString(4, annee);
            req.setString(5, departement);
            req.setString(6, specialite);
            req.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Ajout d'un Etudiant
     * @param matricule codeBarre 
     * @param nom
     * @param prenom
     * @param specialite
     * @param niveau 
     */
    @Override
    public void ajoutEtudiant(String matricule, String nom, String prenom, String specialite, String niveau, String groupe) {
         con = Connexion.getConnection();
        try {
            PreparedStatement req = con.prepareStatement("insert into planning values(?,?,?,?,?,?);");
            req.setString(1,matricule);
            req.setString(2, nom);
            req.setString(3,prenom );
            req.setString(4, specialite);
            req.setString(5, niveau);
            req.setString(6, groupe);
            req.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Ajout d'un Enseignant
     * @param codeBarre
     * @param nom
     * @param prenom 
     */
    @Override
    public void ajoutEnseignant(String codeBarre, String nom ,String prenom){
       try {
            PreparedStatement req = con.prepareStatement("insert into planning values(?,?,?,?,?);");
            req.setString(1,codeBarre);
            req.setString(2, nom);
            req.setString(3,prenom );
            req.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

   
   /**
    * Consultation d'un ou plusieurs plannings, la recherche peut s'effectuer par plusieurs manières selon les valeurs entrées
    * @param annee on peut effectuer une recherche selon l'annee
    * @param faculte on peut effectuer une recherche selon la faculte
    * @param departement ... selon le departement
    * @param niveau ... selon le niveau
    * @param semestre ... selon le semestre 
    * @return Liste des plannings 
    */ 
    @Override
    public ArrayList<Planning> consultePlannings(String annee, String faculte,String departement, String niveau, String semestre){
      String query ="select * from planning  ";
      ArrayList<Planning> plannigs = new ArrayList<Planning>();
      
        if(( annee != null ) || (faculte != null )|| (departement != null) ||( niveau != null )|| (semestre != null)) {
            query+="where ";
            query += ( annee != null ) ?"# annee='"+annee+"' # ":"";
        query += ( faculte != null ) ?"# faculte like '%"+faculte+"%' # ":"";
        query += ( departement != null ) ?"# departement like '%"+departement+"%' # ":"";
        query += ( niveau != null ) ?"# niveau='"+niveau+"' # ":"";
        query += ( semestre != null ) ?"# semestre='"+semestre+"' # ":"";
        String[] req = query.split("#");
        query= req[0];
        for(int  i= 1 ; i != req.length ; i ++ ){
        query+= req[i]+"and";}
        query+=";";
        query = query.replace("and and", "and");
        query = query.replace("and;", ";");
        }else{
            query+=";";
        }
        
        System.out.println(query);
        con= Connexion.getConnection();
        try {
            PreparedStatement requette = con.prepareStatement(query);
            ResultSet res = requette.executeQuery();
            while(res.next()){
                 plannigs.add(new Planning(
                         res.getString("idPl"),
                         res.getString("faculte") ,
                         res.getString("niveau") ,
                         res.getString("semestre"),
                         res.getString("annee"), 
                         res.getString("departement"),
                         res.getString("specialite")
                                            )  );
            }
               
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plannigs;
    }


/**
 * Consultation des enseignant à charge d'un examen
 * @param idPl
 * @param nom
 * @param prenom
 * @param lieu
 * @param module
 * @param date
 * @return une liste d'enseignants surveillants à un examen ou dans un planning
 */
    @Override
    public ArrayList<Enseignant> consulteEnseignants(String idPl, String nom, String prenom, String lieu, String module, Date dateExamen) {
              ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();   
          
           String query ="select en.codebarreEn,en.nom,en.prenom"
                 + " from planning pl,presence pr ,examen ex, enseignant en  "
                 + " where  pl.idPl = '"+idPl+"' and pl.idPl=ex.idPl  "
                 + " and pr.module= ex.module and pr.idPl=ex.idPl  and pr.codebarreEn= en.codebarreEn ";
     
           
            if(( nom != null ) || (prenom != null )|| (module != null) || (dateExamen != null)){
                query += ( nom != null ) ?"# et.nom like '%"+nom+"%' # ":"";
        query += ( prenom != null ) ?"# prenom like '%"+prenom+"%' # ":"";
        query += ( module != null ) ?"# ex.module like '%"+module+"%' # ":"";
        query += ( dateExamen != null ) ?"# semestre='"+dateExamen+"' # ":"";
        String[] req = query.split("#");
        query="";
        for(int  i= 0 ; i != req.length ; i ++ ){
        query+= req[i]+"and";}
        query+=";";
        query = query.replace("and and", "and");
        query = query.replace("and;", ";");
                }else{ 
        query+=";";
            }
            
        System.out.println(query);
        
        
      try {
            con= Connexion.getConnection();
            PreparedStatement requette = con.prepareStatement(query);
            ResultSet res = requette.executeQuery();
           while(res.next()){
                enseignants.add(new Enseignant(
                        res.getString("codebarreEn"),
                        res.getString("nom"),
                        res.getString("prenom") ) );
            }
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enseignants;

    }


    
    
    /**
     * Ajout d'un examen 
     * @param date
     * @param heure
     * @param Module
     * @param idPl 
     */
    @Override
    public void ajoutExamen(String module,String lieu, Date date, String heure,  String idPl){
         con = Connexion.getConnection();
        try {
            PreparedStatement req = con.prepareStatement("insert into examen values(?,?,?,?,?);");
            req.setString(1, lieu);
            req.setDate(2,date);
            req.setString(3, heure);
            req.setString(4, module);
            req.setString(5, idPl);
            req.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 /**
  * consultation d'une liste d'étudiant
  * les tables utilisées : etudiant, presence,planning, examen
  * possibilité de faire une recherche avancée avec les paramètres nom, prenom, niveau
  * @param idPl
  * @param nom
  * @param prenom
  * @param niveau
     * @param dateExamen
  * @param module
  * @return liste d'étudiants
  */
    @Override
    public ArrayList<Etudiant> consulteEtudiants(String idPl, String nom, String prenom, String niveau, Date dateExamen, String module) {
            ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();   
          
           String query ="select et.matricule,et.nom,et.prenom, et.niveau "
                 + " from planning pl,etudiant et,presence pr ,examen ex  "
                 + " where  pl.idPl = '"+idPl+"' and pl.idPl=ex.idPl  "
                 + " and pr.module= ex.module and pr.idPl=ex.idPl  and pr.matricule= et.matricule ";
     
           
            if(( nom != null ) || (prenom != null )|| (niveau != null) || (module != null) || (dateExamen != null)){
                query += ( nom != null ) ?"# et.nom like '%"+nom+"%' # ":"";
        query += ( prenom != null ) ?"# prenom like '%"+prenom+"%' # ":"";
        query += ( module != null ) ?"# ex.module like '%"+module+"%' # ":"";
        query += ( niveau != null ) ?"# et.niveau='"+niveau+"' # ":"";
        query += ( dateExamen != null ) ?"# semestre='"+dateExamen+"' # ":"";
        String[] req = query.split("#");
        query="";
        for(int  i= 0 ; i != req.length ; i ++ ){
        query+= req[i]+"and";}
        query+=";";
        query = query.replace("and and", "and");
        query = query.replace("and;", ";");
                }else{ 
        query+=";";
            }
            
        System.out.println(query);
        
        
      try {
            con= Connexion.getConnection();
            PreparedStatement requette = con.prepareStatement(query);
            ResultSet res = requette.executeQuery();
           while(res.next()){
              /*  etudiants.add(new Etudiant(
                        res.getString("matricule"),
                        res.getString("nom"),
                        res.getString("prenom"), 
                        null, 
                        res.getString("niveau")) );*/
            }
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etudiants;
    }

    @Override
    public void suppAdmin(String nom, String prenom) {
         con = Connexion.getConnection();
        try {
            PreparedStatement req = con.prepareStatement("delete from administration where nom =? and prenom = ? ;");
            req.setString(1, nom);
            req.setString(2,prenom);
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void suppPlanning(String idPl) {
               con = Connexion.getConnection();
        try {
            PreparedStatement req = con.prepareStatement("delete from planning where idPl = ?  ;");
            req.setString(1, idPl);
           
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void suppEnseignant(String codeBarreEn) {
        con = Connexion.getConnection();
        try {
            PreparedStatement req = con.prepareStatement("delete from enseignant where codebarreEn = ?  ;");
            req.setString(1, codeBarreEn);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    
     /**
  * association entre l'etudiant,l'enseignant et l'examen
  * sans oublier que la clé primaire de examen est composée de celle de planning
  * @param matricule
  * @param module
  * @param idPl
  * @param codebarreEn 
  */
 
    @Override
    public void ajoutPresence(String matricule, String module, String idPl, String codebarreEn) {
            
              con = Connexion.getConnection();
        try {
            PreparedStatement req = con.prepareStatement("insert into presence values(?,?,?,?);");
            req.setString(1, matricule);
            req.setString(2, module);
            req.setString(3, idPl);
            req.setString(4, codebarreEn);
            req.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    

  

    

}
