package br.fiap.model;

import br.fiap.conexao.Conexao;

import java.sql.*;

public class DespesaDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public void inserir(Despesa despesa){
        String sql = "insert into java_despesa values(?,?,?,?,?)";
        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setLong(1, despesa.getIdDespesa());
            ps.setString(2, despesa.getDescricao());
            ps.setDouble(3,despesa.getValor());
            ps.setDate(4, Date.valueOf(despesa.getData()));
            ps.setLong(5,despesa.getIdCategoria().getId());
            ps.execute();
        }
        catch(SQLException e){
            System.out.println("Erro ao inserir categoria\n" + e.getMessage());
        }
    }
}
