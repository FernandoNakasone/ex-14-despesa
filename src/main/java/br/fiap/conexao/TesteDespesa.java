package br.fiap.conexao;

import br.fiap.model.Categoria;
import br.fiap.model.Despesa;
import br.fiap.model.DespesaDAO;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TesteDespesa {
    public static void main(String[] args) {
        DespesaDAO dao = new DespesaDAO();
        DecimalFormat dF = new DecimalFormat("R$###,##0.00");

        String data = "19/08/2025";
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        /*Despesa despesa = new Despesa();
        despesa.setIdDespesa(100L);
        despesa.setDescricao("Viagem de uber para a fiap");
        despesa.setValor(45.50);
        despesa.setData(LocalDate.parse(data, mascara));
        despesa.setIdCategoria(new Categoria(2L,""));

        dao.inserir(despesa);*/

        List<Despesa> lista = dao.listar();

        for(Despesa d : lista){
            System.out.println(d.getIdDespesa());
            System.out.println(d.getDescricao());
            System.out.println(dF.format(d.getValor()));
            System.out.println(d.getData().format(mascara));
            System.out.println(d.getIdCategoria().getId());
        }
    }
}
