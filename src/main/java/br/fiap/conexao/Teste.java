package br.fiap.conexao;

import br.fiap.model.Categoria;
import br.fiap.model.CategoriaDAO;

import java.util.List;

public class Teste {
    public static void main(String[] args) {

        //Categoria categoria = new Categoria(10L,"teste");
        CategoriaDAO dao = new CategoriaDAO();
        //dao.inserir(categoria);

        List<Categoria> lista = dao.listar();

        for(Categoria c : lista){
            System.out.println(c.getId() + " - " + c.getCategoria());
        }

    }
}
