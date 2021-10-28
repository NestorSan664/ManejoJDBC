package test;

import datos.Conexion;
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
            
            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);
            
            Persona cambioPersona = new Persona();
            cambioPersona.setId_persona(2);
            cambioPersona.setNombre("Fernanda Abigail");
            cambioPersona.setApellido("Vazquez");
            cambioPersona.setEmail("fvazquez@gmail.com");
            cambioPersona.setTelefono("3366443355");
            personaJDBC.update(cambioPersona);
            
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Adrian");
            nuevaPersona.setApellido("Hernadez");
            nuevaPersona.setEmail("ahernandez@gmail.com");
            nuevaPersona.setTelefono("1155338877");
            personaJDBC.insert(nuevaPersona);
            
            conexion.commit(); 
            System.out.println("Se ha hecjo commit");
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
