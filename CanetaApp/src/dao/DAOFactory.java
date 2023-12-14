package dao;

public class DAOFactory {
       public static CanetaDAO criarCanetaDAO() {
        return new CanetaDAOJDBC();
    } 
       
       public static ModeloDAO criarModeloDAO() {
        return new ModeloDAOJDBC();
    } 
}
