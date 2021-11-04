package datos;

import domain.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    public List<Usuario> select() throws SQLException; 
    
    public int insert(Usuario usuario) throws SQLException;
    
    public int update(Usuario usuario) throws SQLException;
    
    public int delete(Usuario usuario) throws SQLException;
}
