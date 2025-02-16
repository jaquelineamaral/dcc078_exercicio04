package src.main.java.visitor;

import src.main.java.models.Nota;
import src.main.java.models.RelatorioNotasEntrada;
import src.main.java.models.RelatorioNotasSaida;

import java.util.ArrayList;


public class VisitorJSON implements Visitor{

    private ArrayList<Nota> notas = new ArrayList<>();
    StringBuilder listaNotas;


    @Override
    public String gerarRelatorioNotasEntrada(RelatorioNotasEntrada relatorioNotasEntrada) {
        notas = relatorioNotasEntrada.getNotas();
        listaNotas = new StringBuilder();

        listaNotas.append("[");
        for (int i = 0; i < notas.size(); i++) {
            Nota auxNota = notas.get(i);

            listaNotas.append("{")
                      .append("\"id\": \"").append(auxNota.getId()).append("\", ")
                      .append("\"data\": \"").append(auxNota.getData()).append("\", ")
                      .append("\"valor\": ").append(String.format("%.2f", auxNota.getValor()))
                      .append("}");

            if (i < notas.size() - 1) {
                listaNotas.append(", ");
            }
        }
        listaNotas.append("]");


        return "{\n" +
                "  \"Relatório de Notas de Entrada\": {\n" +
                "    \"Mês\": \"" + relatorioNotasEntrada.getMes() + "\",\n" +
                "    \"Total de notas\": " + relatorioNotasEntrada.getNotas().size() + ",\n" +
                "    \"Valor total\": " + String.format("%.2f", relatorioNotasEntrada.getValorTotal()) + ",\n" +
                "    \"Notas\": " + listaNotas.toString() + "\n" +
                "  }\n" +
                "}";

    }



    @Override
    public String gerarRelatorioNotasSaida(RelatorioNotasSaida relatorioNotasSaida) {
        notas = relatorioNotasSaida.getNotas();
        listaNotas = new StringBuilder();

        listaNotas.append("[");
        for (int i = 0; i < notas.size(); i++) {
            Nota auxNota = notas.get(i);

            listaNotas.append("{")
                    .append("\"id\": \"").append(auxNota.getId()).append("\", ")
                    .append("\"data\": \"").append(auxNota.getData()).append("\", ")
                    .append("\"valor\": ").append(String.format("%.2f", auxNota.getValor()))
                    .append("}");

            if (i < notas.size() - 1) {
                listaNotas.append(", ");
            }
        }
        listaNotas.append("]");


        return "{\n" +
                "  \"Relatório de Notas de Saída\": {\n" +
                "    \"Mês\": \"" + relatorioNotasSaida.getMes() + "\",\n" +
                "    \"Total de notas\": " + relatorioNotasSaida.getNotas().size() + ",\n" +
                "    \"Valor total\": " + String.format("%.2f", relatorioNotasSaida.getValorTotal()) + ",\n" +
                "    \"Notas\": " + listaNotas.toString() + "\n" +
                "  }\n" +
                "}";
    }
}
