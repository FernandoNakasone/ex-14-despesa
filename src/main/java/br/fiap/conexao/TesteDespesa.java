package br.fiap.conexao;

import br.fiap.model.Categoria;
import br.fiap.model.Despesa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteDespesa {
    public static void main(String[] args) {
        String data = "19/08/2025";
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Despesa despesa = new Despesa();
        despesa.setIdDespesa(100L);
        despesa.setDescricao("Viagem de uber para a fiap");
        despesa.setValor(45.50);
        despesa.setData(LocalDate.parse(data, mascara));
        despesa.setIdCategoria(new Categoria(2L,""));
    }
}
