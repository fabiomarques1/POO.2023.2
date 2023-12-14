
package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.Caneta;
import java.sql.*;
import modelo.Modelo;


public class CanetaDAOJDBC implements CanetaDAO {

    Connection conexao = null;
    PreparedStatement sql = null;
    ResultSet rset = null;
    
    @Override
    public int inserir(Caneta caneta) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO caneta(codigo_modelo, cor, ponta, carga, tampada) ")
                .append("VALUES (?, ?, ?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {          
            linha = DAOGenerico.executarComando(insert, caneta.getModelo().getCodigo(), caneta.getCor(), caneta.getPonta(), caneta.getCarga(), caneta.isTampada());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        
        return linha;
    }

    @Override
    public int editar(Caneta caneta) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE caneta SET ")
                .append("codigo_modelo = ?,")
                .append("cor = ?, ")
                .append("ponta = ?,")
                .append("carga = ?,")
                .append("tampada = ? ")
                .append("WHERE codigo = ?");
        
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            
            linha = DAOGenerico.executarComando(update, caneta.getModelo().getCodigo(), caneta.getCor(), caneta.getPonta(), caneta.getCarga(), caneta.isTampada(), caneta.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }

    @Override
    public int apagar(int codigo) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM caneta ")
                .append("WHERE codigo = ?");
        
        String delete = sqlBuilder.toString();
        int linha = 0;
        try {         
            linha = DAOGenerico.executarComando(delete, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return linha;
    }

    @Override
    public List<Caneta> listar() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("SELECT c.codigo, c.codigo_modelo, m.descricao, c.cor, c.ponta, c.carga, c.tampada ")
                .append("FROM caneta c ")
                .append("INNER JOIN modelo m ON (c.codigo_modelo = m.codigo)");
        String select = sqlBuilder.toString();

        List<Caneta> canetas = new ArrayList<Caneta>();

        try {       
            rset = DAOGenerico.executarConsulta(select);


            while (rset.next()) {

                Caneta caneta = new Caneta();
                caneta.setCodigo(rset.getInt("c.codigo"));
                
                caneta.setCor(rset.getString("c.cor"));
                caneta.setPonta(rset.getFloat("c.ponta"));
                caneta.setCarga(rset.getInt("c.carga"));
                caneta.setTampada(rset.getBoolean("c.tampada"));
                
                Modelo modelo = new Modelo();
                modelo.setCodigo(rset.getInt("c.codigo_modelo"));
                modelo.setDescricao(rset.getString("m.descricao"));
                
                caneta.setModelo(modelo);

                canetas.add(caneta);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return canetas;
    }

    @Override
    public Caneta listar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void fecharConexao() {
        try {
            if (rset != null) {
                rset.close();
            }
            if (sql != null) {
                sql.close();
            }

            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
