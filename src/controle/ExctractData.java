package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import model.Enseignant;
import model.Etudiant;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

 
public class ExctractData {
    
    
    
    
    
    
    public ArrayList<Etudiant> exractEtudiantFromXls(String file ){
        String matricule ;
        String nom ;
        String prenom ;
        String groupe ;
        
        ArrayList<Etudiant> etudiant =  new ArrayList<Etudiant>();
        
            try{
            FileInputStream fileEt = new FileInputStream(new File(file));
            POIFSFileSystem poiEt = new POIFSFileSystem(fileEt);
            HSSFWorkbook xlsEt = new HSSFWorkbook(poiEt); 
            HSSFSheet classeur = xlsEt.getSheetAt(0);
            Iterator feuilles = classeur.rowIterator();
            Iterator cellules ;
            HSSFRow feuille;
            HSSFCell cellule;
            while(feuilles.hasNext()){
                 feuille = (HSSFRow) feuilles.next();
                cellules = feuille.cellIterator();
                
               
                     cellule = (HSSFCell) cellules.next(); 
                    matricule = ""+((int)cellule.getNumericCellValue());
                    
                    
                    cellule = (HSSFCell) cellules.next();
                    nom =  cellule.getStringCellValue();
                    
                    cellule = (HSSFCell) cellules.next();
                    prenom =  cellule.getStringCellValue();
                
                    
                    cellule = (HSSFCell) cellules.next();
                    groupe =  cellule.getStringCellValue();
                    
                    etudiant.add(new Etudiant(matricule, nom,prenom,groupe)); 
                    
            }
            
            }catch(IOException e){
            System.err.println(e.toString());
              } 
            
            
            return etudiant ;
    }
    
    public ArrayList<Enseignant> extractEnseignantFromXls(String file){
         String codebarreEn ;
        String nom ;
        String prenom ;
        
        
        ArrayList<Enseignant> enseignant =  new ArrayList<Enseignant>();
        
            try{
            FileInputStream fileEt = new FileInputStream(new File(file));
            POIFSFileSystem poiEt = new POIFSFileSystem(fileEt);
            HSSFWorkbook xlsEt = new HSSFWorkbook(poiEt); 
            HSSFSheet classeur = xlsEt.getSheetAt(0);
            Iterator feuilles = classeur.rowIterator();
            Iterator cellules ;
            HSSFRow feuille;
            HSSFCell cellule;
            while(feuilles.hasNext()){
                feuille = (HSSFRow) feuilles.next();
                cellules = feuille.cellIterator();
                
               
                    cellule = (HSSFCell) cellules.next(); 
                    codebarreEn = ""+((int)cellule.getNumericCellValue());
                    
                    
                    cellule = (HSSFCell) cellules.next();
                    nom =  cellule.getStringCellValue();
                    
                    cellule = (HSSFCell) cellules.next();
                    prenom =  cellule.getStringCellValue();
                
                    enseignant.add(new Enseignant(codebarreEn, nom,prenom)); 
                    
            }
            
            }catch(IOException e){
            System.err.println(e.toString());
              } 
            
            return enseignant;
    }
    
    
    public void exctractPlanningFromXls(){
        /**
         * on va créer un plannig
         * on va créer les examens
         * on va identifier les codebarres des enseignants à partir 
         * de la lise des enseignant grace à leurs noms et prenoms
         * on va créer les présences 
         * 
         */
        
        java.util.Date date ; 
        String module ;
        String nomEn ;
        String prenomEn ;
        String codebarreEn ;
        
        
    }
    
    
    public static void main(String[] args){
        
        String codebarreEn ;
        String nom ;
        String prenom ;
        String groupe ;
        
        ArrayList<Enseignant> enseignant =  new ArrayList<Enseignant>();
        
            try{
            FileInputStream fileEt = new FileInputStream(new File("etudiants.xls"));
            POIFSFileSystem poiEt = new POIFSFileSystem(fileEt);
            HSSFWorkbook xlsEt = new HSSFWorkbook(poiEt); 
            HSSFSheet classeur = xlsEt.getSheetAt(0);
            Iterator feuilles = classeur.rowIterator();
            Iterator cellules ;
            while(feuilles.hasNext()){
                HSSFRow feuille = (HSSFRow) feuilles.next();
                cellules = feuille.cellIterator();
                
               
                    HSSFCell cellule = (HSSFCell) cellules.next(); 
                    codebarreEn = ""+((int)cellule.getNumericCellValue());
                    
                    
                    cellule = (HSSFCell) cellules.next();
                    nom =  cellule.getStringCellValue();
                    
                    cellule = (HSSFCell) cellules.next();
                    prenom =  cellule.getStringCellValue();
                
                    
                    
                    
                    enseignant.add(new Enseignant(codebarreEn, nom,prenom)); 
                    
            }
            
            }catch(IOException e){
            System.err.println(e.toString());
              } 
            
            
            for(Enseignant en :  enseignant){
                System.out.println(en.toString());
            }
            
          /* try{
            FileInputStream file = new FileInputStream(new File("planning.xls"));
            POIFSFileSystem poi = new POIFSFileSystem(file);
            HSSFWorkbook xls = new HSSFWorkbook(poi); 
            HSSFSheet classeur = xls.getSheetAt(0);
            Iterator feuilles = classeur.rowIterator();
            Iterator cellules ;
            while(feuilles.hasNext()){
                HSSFRow feuille = (HSSFRow) feuilles.next();
                cellules = feuille.cellIterator();
                
                while(cellules.hasNext()){
                    HSSFCell cellule = (HSSFCell) cellules.next(); 
                    System.out.println(cellule);
                }
            }
            
            
            
        }catch(IOException e){
            System.err.println(e.toString());
        } 
        */
    }
    
}
