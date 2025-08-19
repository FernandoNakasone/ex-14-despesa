package br.fiap.model;

import br.fiap.conexao.Conexao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Despesa> listar(){
        List<Despesa> lista = new ArrayList<>();
        String sql = "select * from java_despesa";

        try(Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Despesa despesa = new Despesa();
                despesa.setIdDespesa(rs.getLong("id_despesa"));
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setData(rs.getDate("data").toLocalDate());
                despesa.setIdCategoria(new Categoria(rs.getLong("id_categoria"), ""));

                lista.add(despesa);
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao listar categorias\n" + e.getMessage());
        }

        return lista;
    }
}
