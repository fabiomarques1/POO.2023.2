
package dao;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import modelo.Modelo;

public interface ModeloDAO {
    public int inserir(Modelo modelo);
    public int editar(Modelo modelo);
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException;
    public List<Modelo> listar();
    public Modelo listar(int codigo);
}
