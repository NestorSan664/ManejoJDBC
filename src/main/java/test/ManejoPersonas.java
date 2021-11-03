package test;

import datos.Conexion;
import datos.PersonaDAO;
import datos.PersonaJDBC;
import domain.Persona;
import java.sql.*;
import java.util.List;

public class ManejoPersonas {

    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit())
                conexion.setAutoCommit(false);
            
            PersonaDAO personaDAO = new PersonaJDBC(conexion);
            
            List<Persona> personas = personaDAO.select();
            
            for(Persona persona : personas) {
                System.out.println("Persona: " + persona);
            }
            conexion.commit();
            System.out.println("Commit");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
    }
}
