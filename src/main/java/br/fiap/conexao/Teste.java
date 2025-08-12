package br.fiap.conexao;

import br.fiap.model.Categoria;
import br.fiap.model.CategoriaDAO;

public class Teste {
    public static void main(String[] args) {

        Categoria categoria = new Categoria(4L,"outros");
        CategoriaDAO dao = new CategoriaDAO();
        dao.inserir(categoria);

    }
}
