package src.main.java.visitor;

import src.main.java.models.Nota;
import src.main.java.models.RelatorioNotasEntrada;
import src.main.java.models.RelatorioNotasSaida;

import java.util.ArrayList;


public class VisitorCSV implements Visitor {

    private ArrayList<Nota> notas = new ArrayList<>();
    StringBuilder csvRelatorio;


    @Override
    public String gerarRelatorioNotasEntrada(RelatorioNotasEntrada relatorioNotasEntrada) {
        notas = relatorioNotasEntrada.getNotas();
        csvRelatorio = new StringBuilder();

        csvRelatorio.append("Relatório de Notas de Entrada\n");
        csvRelatorio.append("Mês,Total de notas,Valor total\n");
        csvRelatorio.append(relatorioNotasEntrada.getMes()).append(",")
                    .append(notas.size()).append(",")
                    .append(String.format("%.2f", relatorioNotasEntrada.getValorTotal())).append("\n");

        csvRelatorio.append("\nNotas de Entrada\n");
        csvRelatorio.append("ID,Data,Valor\n");

        for (Nota nota : notas) {
            csvRelatorio.append(nota.getId()).append(",")
                        .append(nota.getData()).append(",")
                        .append(String.format("%.2f", nota.getValor())).append("\n");
        }

        return csvRelatorio.toString();
    }


    @Override
    public String gerarRelatorioNotasSaida(RelatorioNotasSaida relatorioNotasSaida) {
        notas = relatorioNotasSaida.getNotas();
        csvRelatorio = new StringBuilder();

        csvRelatorio.append("Relatório de Notas de Saída\n");
        csvRelatorio.append("Mês,Total de notas,Valor total\n");
        csvRelatorio.append(relatorioNotasSaida.getMes()).append(",")
                .append(notas.size()).append(",")
                .append(String.format("%.2f", relatorioNotasSaida.getValorTotal())).append("\n");

        csvRelatorio.append("\nNotas de Saída\n");
        csvRelatorio.append("ID,Data,Valor\n");

        for (Nota nota : notas) {
            csvRelatorio.append(nota.getId()).append(",")
                    .append(nota.getData()).append(",")
                    .append(String.format("%.2f", nota.getValor())).append("\n");
        }

        return csvRelatorio.toString();
    }
}
