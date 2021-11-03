package datos;

import domain.Persona;
import java.sql.SQLException;
import java.util.List;

public interface PersonaDAO {
    
    public List<Persona> select() throws SQLException; 
    
    public int insert(Persona persona) throws SQLException;
    
    public int update(Persona persona) throws SQLException;
    
    public int delete(Persona persona) throws SQLException;
}
