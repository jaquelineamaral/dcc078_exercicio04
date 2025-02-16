package src.main.java.visitor;

import src.main.java.models.Nota;
import src.main.java.models.RelatorioNotasEntrada;
import src.main.java.models.RelatorioNotasSaida;

import java.util.ArrayList;


public class VisitorHTML implements Visitor {

    private ArrayList<Nota> notas = new ArrayList<>();
    StringBuilder listaNotas;


    @Override
    public String gerarRelatorioNotasEntrada(RelatorioNotasEntrada relatorioNotasEntrada) {
        notas = relatorioNotasEntrada.getNotas();
        listaNotas = new StringBuilder();

        for (int i = 0; i < notas.size(); i++) {
            Nota auxNota = notas.get(i);

            listaNotas.append("<li>").append(auxNota.getId()).append("   ").append(auxNota.getData()).append("   ").append(auxNota.getValor()).append("   ").append("</li>");
        }

        return "<html>\n<body>\n" +
               "<h1>Relatorio de Notas de Entrada</h1>\n" +
               "<p>Mês: " + relatorioNotasEntrada.getMes() + "</p>\n" +
               "<p>Total de notas: " + relatorioNotasEntrada.getNotas().size() + "</p>\n" +
               "<p>Valor total: R$" + String.format("%.2f", relatorioNotasEntrada.getValorTotal()) + "</p>\n" +
               "<h2>Notas de entrada</h2>\n" +
               "<ul>\n" + listaNotas + "\n</ul>\n" +
               "</body></html>";
    }


    @Override
    public String gerarRelatorioNotasSaida(RelatorioNotasSaida relatorioNotasSaida) {
        notas = relatorioNotasSaida.getNotas();
        listaNotas = new StringBuilder();

        for (int i = 0; i < notas.size(); i++) {
            Nota auxNota = notas.get(i);

            listaNotas.append("<li>").append(auxNota.getId()).append("   ").append(auxNota.getData()).append("   ").append(auxNota.getValor()).append("   ").append("</li>");
        }

        return "<html>\n<body>\n" +
                "<h1>Relatorio de Notas de Saída</h1>\n" +
                "<p>Mês: " + relatorioNotasSaida.getMes() + "</p>\n" +
                "<p>Total de notas: " + relatorioNotasSaida.getNotas().size() + "</p>\n" +
                "<p>Valor total: R$" + String.format("%.2f", relatorioNotasSaida.getValorTotal()) + "</p>\n" +
                "<h2>Notas de saída</h2>\n" +
                "<ul>\n" + listaNotas + "\n</ul>\n" +
                "</body></html>";
    }

}
