package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private String USER = "rm558179";
    private String PASSWORD = "fiap25";
    private Connection conexao;

    public Connection conectar(){

        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            System.out.println("Erro ao conectar no banco de dados\n" + e.getMessage());
        }
        return conexao;
    }
}
