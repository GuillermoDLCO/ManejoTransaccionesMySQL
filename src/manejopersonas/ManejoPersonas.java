package manejopersonas;

import datos.Conexion;
import datos.PersonasJDBC;
import java.sql.*;

public class ManejoPersonas {

    public static void main(String[] args) {
        PersonasJDBC personasJDBC = new PersonasJDBC();
        
        Connection conn = null;
        
        try {
            conn = Conexion.getConnection();
            
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            PersonasJDBC personas = new PersonasJDBC(conn);
            personas.update(1, "sads", "ggggg");
            
            personas.insert("KOok", "jojo");
            conn.commit();
        } catch (SQLException e) {
            try {
                System.out.println("Entramos al rollback");
            
                e.printStackTrace();
                conn.rollback();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
        }
        
        
    }
    
}
