
package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connexion {
    
    private static Connection con ;
    /**
     * ce qui se trouve à l'intérieur du bloc static va s'executer une seule fois
     */
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_presences","root","");
            System.out.println("connexion réussie");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static  Connection getConnection(){
        return con ;
    }
    
}
